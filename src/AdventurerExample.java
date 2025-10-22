import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
}
