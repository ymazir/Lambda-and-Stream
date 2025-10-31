import java.util.List;

/**
 * Represents a guild that contains a list of adventurers.
 */
public class Guild implements Comparable<Guild> {
    private String name;
    private List<Adventurer> adventureres;


    /**
     * Constructs a Guild with the specified name and list of adventurers.
     *
     * @param name          The name of the guild.
     * @param adventureres  The list of adventurers in the guild.
     */
    public Guild(String name, List<Adventurer> adventureres) {
        this.name = name;
        this.adventureres = adventureres;
    }


    // Getters
    /**
     * Returns the name of the guild.
     *
     * @return The name of the guild.
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the list of adventurers in the guild.
     *
     * @return The list of adventurers.
     */
    public List<Adventurer> getAdventureres() {
        return adventureres;
    }


    // Setters
    /**
     * Sets the name of the guild.
     *
     * @param name The new name of the guild.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Sets the list of adventurers in the guild.
     *
     * @param adventureres The new list of adventurers.
     */
    public void setAdventureres(List<Adventurer> adventureres) {
        this.adventureres = adventureres;
    }

    // Other methods
    /**
     * Adds an adventurer to the guild.
     *
     * @param adventurer The adventurer to be added.
     */
    public void addAdventurer(Adventurer adventurer) {
        this.adventureres.add(adventurer);
    }
    /**
     * Compares this guild with another guild based on the number of adventurers.
     *
     * @param other The other guild to compare with.
     * @return A positive integer if this guild has more adventurers,
     *         zero if they have the same number,
     *         or a negative integer if this guild has fewer adventurers.
     */
    @Override
    public int compareTo(Guild other) {
        if (this.getAdventureres().size() > other.getAdventureres().size()) {
            return 1;
        } else if (this.getAdventureres().size() == other.getAdventureres().size()) {
            return 0;
        } else {
            return -1;
        }
    }
}
