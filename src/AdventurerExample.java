import java.util.*;
import java.util.stream.Collectors;


public class AdventurerExample {
    /**
     * Filters adventurers across all guilds based on a specific skill.
     *
     * @param guilds List of guilds to extract adventurers from.
     * @param skillToFilter The skill to filter adventurers by.
     * @return A list of adventurers who possess the specified skill.
     */
    public static List<Adventurer> filterAdventurers(List<Guild> guilds, Skill skillToFilter) {
        return guilds.stream()                                                         // Starts the stream
                .flatMap(m -> m.getAdventureres().stream())                            // Flattens the stream of guilds into a stream of adventurers
                .filter(p -> p.getSkills().contains(skillToFilter))                    // Filters adventurers by checking if their skills contain the specified skill
                .collect(Collectors.toList());                                         // Collects the filtered adventurers into a list and returns it
    }

    /**
     * Groups adventurers by their roles across all guilds.
     *
     * @param guilds List of guilds to extract adventurers from.
     * @return A map where the key is the Role and the value is a list of adventurers with that role.
     */
    public static Map<Role, List<Adventurer>> groupAdventurersByRoles(List<Guild> guilds) {
        Map<Role, List<Adventurer>> groups = guilds.stream()                    // Starts the stream
                .flatMap(m -> m.getAdventureres().stream())                     // Flattens the stream of guilds into a stream of adventurers
                .collect(Collectors.groupingBy(Adventurer::getRole));           // Groups adventurers by their role into a map

        for (Role role : groups.keySet()) {                                     // Iterates over each role in the map
            System.out.println("Role: " + role);                                // Prints the role
            for (Adventurer adventurer : groups.get(role)) {                    // Iterates over each adventurer in the list for that role
                System.out.println(" - " + adventurer.getName());               // Prints the adventurer's name
            }
        }
        return groups;                                                          // Returns the map of grouped adventurers
    }


    /**
     * Finds the adventurer with the highest number of skills across all guilds.
     *
     * @param guilds List of guilds to search through.
     * @return The adventurer with the most skills.
     */
    public static Adventurer getMostSkilledAdventurer(List<Guild> guilds) {
        return guilds.stream()                                                     // Starts the stream
                .flatMap(m -> m.getAdventureres().stream())                        // Flattens the stream of guilds into a stream of adventurers
                .max(Comparator.comparingInt(a -> a.getSkills().size()))           // Finds the adventurer with the maximum number of skills
                .get();                                                            // Retrieves the adventurer from the Optional and returns it
    }

    /**
     * Ranks guilds by the average age of their adventurers in ascending order.
     *
     * @param guilds List of guilds to be ranked.
     * @return A new list of guilds sorted by the average age of their adventurers.
     */
    public static List<Guild> rankGuildsByAverageAdventurerAge(List<Guild> guilds) {

        return guilds.stream()                                              // Starts the stream
                .sorted(Comparator                                          // Sorts the stream by a comparator were about to give it
                        .comparingDouble(g -> g.getAdventureres().stream()  // Comparing by double, but first get reach guild and make a stream of all of its adventurers
                        .mapToInt(Adventurer::getAge)                       // Maps each adventurer to their age as an int
                        .average()                                          // Gets the average of the ages in the stream
                        .orElse(0)))                                  // The whole thing breaks if this isnt here fuck this stupid thing bro its just a default to 0
                .collect(Collectors.toList());                              // Collects the sorted stream of guilds into a new list then returns

    }

    /**
     * Creates a map where the key is a Skill and the value is the number of adventurers that are proficient in that skill.
     *
     * @param guilds
     * @return A new Map where the keys are the skill names and the values are the number of adventurers that are proficient in said skill.
     */
    public static Map<String, Long> skillWiseAdventurerCount(List<Guild> guilds) {

        Map<String, Long> temp = guilds.stream()                                        // Starts the stream as a map<String, Long> object so it can be printed before being returned.
                .flatMap(g -> g.getAdventureres().stream())                             // Flattens the stream of guilds into a stream of adventurers.
                .flatMap(a -> a.getSkills().stream())                                   // Flattens the stream of adventurers into a stream of skills.
                .collect(Collectors.groupingBy(Skill::name, Collectors.counting()));    // Groups the skills by their name and counts the number of adventurers proficient in each skill.

        for (Map.Entry entry : temp.entrySet() ) {                                      // Iterates through the map entries to print them.
            System.out.println(entry.getKey() + ", " + entry.getValue());               // Prints each skill and the corresponding count of adventurers.
        }

        return temp;                                                                    // Returns the map of skills and their corresponding adventurer counts.
    }


    /**
     * Applies a gold bonus event where adventurers with less than 1000 gold earned receive a 20% bonus.
     *
     * @param guilds List of guilds containing adventurers to apply the bonus to.
     */
    public static void goldBonusEvent(List<Guild> guilds) {
       guilds.stream().                                                                          // Starts the stream
               flatMap(g -> g.getAdventureres().stream())                                        // Flattens the stream of guilds into a stream of adventurers
               .filter(a -> a.getGoldEarned() < 1000)                                            // Filters adventurers with less than 1000 gold earned
               .forEach(adventurer -> adventurer.setGoldEarned(adventurer.getGoldEarned()*1.2)); // Applies a 20% bonus to their gold earned

       guilds.stream().                                                                          // Starts the stream again to print the updated gold earned for all adventurers
               flatMap(g -> g.getAdventureres().stream())                                        // Flattens the stream of guilds into a stream of adventurers
               .forEach(adventurer -> System.out.println(adventurer.getName() + ": " + adventurer.getGoldEarned())); // Prints each adventurer's name and their updated gold earned
    }
}
