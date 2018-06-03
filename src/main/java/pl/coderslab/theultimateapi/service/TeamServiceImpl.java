package pl.coderslab.theultimateapi.service;

import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.coderslab.theultimateapi.entity.Team;
import pl.coderslab.theultimateapi.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    //////////////// to api ////////////////

    public ArrayList<JSONObject> getTeams() {
        return teams;
    }

    private ArrayList<JSONObject> teams = new ArrayList<>();

    @Scheduled(fixedRate = 5000)
    public void regenerate() throws JSONException {
        teams.clear();
        List<Team> allTeams = teamRepository.findAll();
        for (Team t: allTeams) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("id", t.getId());
            oJsonInner.put("name", t.getName());
            oJsonInner.put("seeding", t.getSeeding());
            oJsonInner.put("strength", t.getStrength());
            teams.add(oJsonInner);
        }
    }





    /////////////// initial ///////////////


    public void addTeamToDb (String name, double strength, int seeding) {
        Team team = new Team();
        team.setName(name);
        team.setStrength(strength);
        team.setSeeding(seeding);
        teamRepository.save(team);
    }

    ////////////// crud //////////////////

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findById(Long id) {
        return teamRepository.findTeamById(id);
    }

    @Override
    public void updateTeam(Team team) {
        teamRepository.save(team);
    }


}
