import java.util.List;

public class Main {
    public static void main(String[] args) {

        Adventurer adventurer1 = new Adventurer("Arin", 25, Role.Warrior, 1500.0, List.of(Skill.SWORDSMANSHIP, Skill.HORSEMANSHIP));
        Adventurer adventurer2 = new Adventurer("Lina", 232, Role.Rouge, 1200.0, List.of(Skill.ARCHERY, Skill.STEALTH));
        Adventurer adventurer3 = new Adventurer("random", 29000, Role.Rouge, 999.0, List.of(Skill.THIEVERY, Skill.STEALTH));
        Adventurer adventurer4 = new Adventurer("Mira", 30, Role.Wizard, 2000.0, List.of(Skill.NECROMANCY, Skill.RUNECRAFTING));
        Adventurer adventurer5 = new Adventurer("Doran", 28, Role.Warrior, 1800.0, List.of(Skill.SWORDSMANSHIP, Skill.BLACKSMITHING));
        Adventurer adventurer6 = new Adventurer("Mike", 205, Role.Rouge, 1000000000.0, List.of(Skill.HEALING, Skill.BLACKSMITHING, Skill.HORSEMANSHIP, Skill.ARCHERY, Skill.THIEVERY, Skill.MEMECRAFTING, Skill.NECROMANCY, Skill.STEALTH, Skill.RUNECRAFTING, Skill.SWORDSMANSHIP));


        Guild guild1 = new Guild("test", List.of(adventurer1, adventurer2, adventurer3));
        Guild guild2 = new Guild("testAgainlol", List.of(adventurer4, adventurer5, adventurer6));


        System.out.println(AdventurerExample.filterAdventurers(List.of(guild1, guild2), Skill.BLACKSMITHING));

        System.out.println(AdventurerExample.groupAdventurersByRoles(List.of(guild1, guild2)));

        System.out.println(AdventurerExample.getMostSkilledAdventurer(List.of(guild1, guild2)).getName());

        List<Guild> sortedByAverageAgeListGuilds = AdventurerExample.rankGuildsByAverageAdventurerAge(List.of(guild1, guild2));

        for (Guild guild : sortedByAverageAgeListGuilds) {

            System.out.println(guild + " " + getAverageAge(guild));
        }


        System.out.println(AdventurerExample.skillWiseAdventurerCount(List.of(guild1, guild2)));

        AdventurerExample.goldBonusEvent(List.of(guild1, guild2));

    }

    // Helper method to demonstrate functionality of AdventurerExample.rankGuildsByAverageAdventurerAge
    public static int getAverageAge(Guild guild) {
        int counter = 0;
        for (Adventurer adv : guild.getAdventureres()) {
            counter += adv.getAge();
        }
        return counter / guild.getAdventureres().size();
    }
}