import java.util.Comparator;
import  java.util.List;

/**
 * Represents an adventurer with various attributes such as name, age, role, gold earned, and skills.
 */
public class Adventurer implements Comparable<Adventurer> {
    private String name;
    private int age;
    private Role role;
    private double goldEarned;
    private List<Skill> skills;
    /**
     * Constructs an Adventurer with the specified attributes.
     *
     * @param name        The name of the adventurer.
     * @param age         The age of the adventurer.
     * @param role        The role of the adventurer.
     * @param goldEarned  The amount of gold earned by the adventurer.
     * @param skills      The list of skills possessed by the adventurer.
     */
    public Adventurer(String name, int age, Role role, double goldEarned, List<Skill> skills) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.goldEarned = goldEarned;
        this.skills = skills;
    }

    /**
     * Constructs an Adventurer with default attributes.
     */
    // Getters
    public String getName() {
        return name;
    }
    /**
     * Returns the age of the adventurer.
     *
     * @return The age of the adventurer.
     */

    public int getAge() {
        return age;
    }


    /**
     * Returns the role of the adventurer.
     *
     * @return The role of the adventurer.
     */
    public Role getRole() {
        return role;
    }
    /**
     * Returns the amount of gold earned by the adventurer.
     *
     * @return The amount of gold earned.
     */
    public double getGoldEarned() {
        return goldEarned;
    }
    /**
     * Returns the list of skills possessed by the adventurer.
     *
     * @return The list of skills.
     */
    public List<Skill> getSkills() {
        return skills;
    }


     // Setters
    /**
     * Sets the name of the adventurer.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
       this.name = name;
    }
    /**
     * Sets the age of the adventurer.
     *
     * @param age The age to set.
     */
    public void setAge(int age) {
       this.age = age;
    }
    /**
     * Sets the role of the adventurer.
     *
     * @param role The role to set.
     */
    public void setRole(Role role) {
       this.role = role;
    }
     /**
     * Sets the amount of gold earned by the adventurer.
     *
     * @param goldEarned The amount of gold to set.
     */
    public void setGoldEarned(double goldEarned) {
       this.goldEarned = goldEarned;
    }
    /**
     * Sets the skills of the adventurer.
     *
     * @param skills The list of skills to set.
     */
    public void setSkills(List<Skill> skills) {
       this.skills = skills;
    }
/**     * Compares this adventurer to another based on the amount of gold earned.
     *
     * @param other The other adventurer to compare to.
     * @return A positive integer if this adventurer has earned more gold,
     *         zero if they have earned the same amount,
     *         or a negative integer if this adventurer has earned less gold.
     */
    @Override
    public int compareTo(Adventurer other) {
        if (this.goldEarned > other.goldEarned) {
            return 1;
        } else if (this.goldEarned == other.goldEarned) {
            return 0;
        } else {
            return -1;
        }
    }
}
