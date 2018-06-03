package pl.coderslab.theultimateapi.service;

import pl.coderslab.theultimateapi.entity.Team;

import java.util.List;

public interface TeamService {

    public void addTeamToDb (String name, double strength, int seeding);

    public List<Team> findAll ();

    public Team findById (Long id);

    public void updateTeam (Team team);
}
