import java.util.Comparator;
import  java.util.List;

public class Adventurer implements Comparable<Adventurer> {
    private String name;
    private int age;
    private Role role;
    private double goldEarned;
    private List<Skill> skills;

    public Adventurer(String name, int age, Role role, double goldEarned, List<Skill> skills) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.goldEarned = goldEarned;
        this.skills = skills;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

     public Role getRole() {
         return role;
     }

     public double getGoldEarned() {
         return goldEarned;
     }

     public List<Skill> getSkills() {
         return skills;
     }


     // Setters

     public void setName(String name) {
        this.name = name;
     }

     public void setAge(int age) {
        this.age = age;
     }

     public void setRole(Role role) {
        this.role = role;
     }

     public void setGoldEarned(double goldEarned) {
        this.goldEarned = goldEarned;
    }

     public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }





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
