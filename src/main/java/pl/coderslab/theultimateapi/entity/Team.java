package pl.coderslab.theultimateapi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int seeding;

    private double strength;

    @OneToMany(mappedBy = "team1")
    private List<Game> gamesAsTeam1;

    @OneToMany(mappedBy = "team2")
    private List<Game> gamesAsTeam2;

    @ManyToOne
    private Group group;

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Game> getGamesAsTeam1() {
        return gamesAsTeam1;
    }

    public void setGamesAsTeam1(List<Game> gamesAsTeam1) {
        this.gamesAsTeam1 = gamesAsTeam1;
    }

    public List<Game> getGamesAsTeam2() {
        return gamesAsTeam2;
    }

    public void setGamesAsTeam2(List<Game> gamesAsTeam2) {
        this.gamesAsTeam2 = gamesAsTeam2;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
