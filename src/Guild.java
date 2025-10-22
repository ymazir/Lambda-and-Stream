import java.util.List;

public class Guild implements Comparable<Guild> {
    private String name;
    private List<Adventurer> adventureres;


    public Guild(String name, List<Adventurer> adventureres) {
        this.name = name;
        this.adventureres = adventureres;
    }


    // Getters

    public String getName() {
        return name;
    }

    public List<Adventurer> getAdventureres() {
        return adventureres;
    }


    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAdventureres(List<Adventurer> adventureres) {
        this.adventureres = adventureres;
    }

    // Other methods

    public void addAdventurer(Adventurer adventurer) {
        this.adventureres.add(adventurer);
    }

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
