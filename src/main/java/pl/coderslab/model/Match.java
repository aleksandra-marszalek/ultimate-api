package pl.coderslab.model;

public class Match {

    private Team team1;

    private Team team2;

    private int pointsTeam1;

    private int pointsTeam2;

    private int oddsTeam1;

    private int oddsTeam2;

    public Match() {
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getPointsTeam1() {
        return pointsTeam1;
    }

    public void setPointsTeam1(int pointsTeam1) {
        this.pointsTeam1 = pointsTeam1;
    }

    public int getPointsTeam2() {
        return pointsTeam2;
    }

    public void setPointsTeam2(int pointsTeam2) {
        this.pointsTeam2 = pointsTeam2;
    }

    public int getOddsTeam1() {
        return oddsTeam1;
    }

    public void setOddsTeam1(int oddsTeam1) {
        this.oddsTeam1 = oddsTeam1;
    }

    public int getOddsTeam2() {
        return oddsTeam2;
    }

    public void setOddsTeam2(int oddsTeam2) {
        this.oddsTeam2 = oddsTeam2;
    }
}
