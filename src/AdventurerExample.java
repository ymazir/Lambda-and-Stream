import java.util.*;
import java.util.stream.Collectors;


public class AdventurerExample {

    ArrayList<Guild> guildList = new ArrayList<>();

    public static List<Adventurer> filterAdventurers(List<Guild> guilds, Skill skillToFilter) {
        return guilds.stream()
                .flatMap(m -> m.getAdventureres().stream())
                .filter(p -> p.getSkills().contains(skillToFilter))
                .collect(Collectors.toList());
    }

    public static Map<Role, List<Adventurer>> groupAdventurersByRoles(List<Guild> guilds) {
        Map<Role, List<Adventurer>> groups = guilds.stream()
                .flatMap(m -> m.getAdventureres().stream())
                .collect(Collectors.groupingBy(Adventurer::getRole));

        //prints anyways and returns the whole map. comment this out more tonight
        for (Role role : groups.keySet()) {
            System.out.println("Role: " + role);
            for (Adventurer adventurer : groups.get(role)) {
                System.out.println(" - " + adventurer.getName());
            }
        }


        return groups;
    }

    public static Adventurer getMostSkilledAdventurer(List<Guild> guilds) {
        return guilds.stream()
                .flatMap(m -> m.getAdventureres().stream())
                .max(Comparator.comparingInt(a -> a.getSkills().size()))
                .get();
    }


    // some bullshit bro holy moly it makes a Map of guilds to integers and returns it after its soorted.
    public static List<Guild> rankGuildsByAverageAdventurerAge(List<Guild> guilds) {

        return guilds.stream()                                           // Starts the stream
                .sorted(Comparator                                       // Sorts the stream by a comparator were about to give it
                        .comparingDouble(g -> g.getAdventureres().stream() // Comparing by double, but first get reach guild and make a stream of all of its adventurers
                        .mapToInt(Adventurer::getAge)                    // Maps each adventurer to their age as an int
                        .average()                                       // Gets the average of the ages in the stream
                        .orElse(0)))                               // The whole thing breaks if this isnt here fuck this stupid thing bro its just a default to 0
                .collect(Collectors.toList());                           // Collects the sorted stream of guilds into a new list then returns

    }

    public static Map<String, Long> skillWiseAdventurerCount(List<Guild> guilds) {

        Map<String, Long> temp = guilds.stream()
                .flatMap(g -> g.getAdventureres().stream())
                .flatMap(a -> a.getSkills().stream())
                .collect(Collectors.groupingBy(Skill::name, Collectors.counting()));

        for (Map.Entry entry : temp.entrySet() ) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }


        return temp;
    }

    public static void goldBonusEvent(List<Guild> guilds) {
       guilds.stream().flatMap(g -> g.getAdventureres().stream()).filter(a -> a.getGoldEarned() < 1000).forEach(adventurer -> adventurer.setGoldEarned(adventurer.getGoldEarned()*1.2));

       guilds.stream().flatMap(g -> g.getAdventureres().stream()).forEach(adventurer -> System.out.println(adventurer.getName() + ": " + adventurer.getGoldEarned()));
    }






}
