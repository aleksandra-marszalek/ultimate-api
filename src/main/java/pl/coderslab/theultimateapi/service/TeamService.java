package pl.coderslab.theultimateapi.service;

import org.json.JSONObject;
import pl.coderslab.theultimateapi.entity.Group;
import pl.coderslab.theultimateapi.entity.Team;

import java.util.ArrayList;
import java.util.List;

public interface TeamService {

    public void addTeamToDb (String name, double strength, int seeding);

    public List<Team> findAll();

    public Team findById (Long id);

    public void updateTeam (Team team);

    public ArrayList<JSONObject> getTeams();

    public void addToGroupBySeeding (Team team);

}
