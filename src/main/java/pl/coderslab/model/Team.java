package pl.coderslab.model;



public class Team {

    private int id;
    private String name;
    private int seeding;
    private double strength;

    public Team() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeeding() {
        return seeding;
    }

    public void setSeeding(int seeding) {
        this.seeding = seeding;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }
}
