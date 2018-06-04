package pl.coderslab.theultimateapi.service;

import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.coderslab.theultimateapi.entity.Group;
import pl.coderslab.theultimateapi.entity.Team;
import pl.coderslab.theultimateapi.repository.GroupRepository;
import pl.coderslab.theultimateapi.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    GroupRepository groupRepository;

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
            JSONObject group = new JSONObject();
            group.put("id", t.getGroup().getId());
            group.put("name", t.getGroup().getName());
            oJsonInner.put("group", group);
            oJsonInner.put("placeInGroup", t.getPlaceInGroup());
            oJsonInner.put("won", t.getWon());
            oJsonInner.put("lost", t.getLost());
            oJsonInner.put("pointBalance", t.getPointBalance());
            oJsonInner.put("finalStanding", t.getFinalStanding());
            teams.add(oJsonInner);
        }
    }






    /////////////// initial ///////////////


    public void addTeamToDb (String name, double strength, int seeding) {
        Team team = new Team();
        team.setName(name);
        team.setStrength(strength);
        team.setSeeding(seeding);
        team.setLost(0);
        team.setWon(0);
        team.setPointBalance(0);
        teamRepository.save(team);
    }

    @Override
    public void addToGroupBySeeding(Team team) {
        Group groupA = groupRepository.findGroupByName("A");
        Group groupB = groupRepository.findGroupByName("B");
        Group groupC = groupRepository.findGroupByName("C");
        Group groupD = groupRepository.findGroupByName("D");
        int seeding = team.getSeeding();
        if (seeding==1 || seeding==8 || seeding==9 || seeding==16) {
            team.setGroup(groupA);
            teamRepository.save(team);
        } else if (seeding==2 || seeding==7 || seeding==10 || seeding==15) {
            team.setGroup(groupB);
            teamRepository.save(team);
        } else if (seeding==3 || seeding==6 || seeding==11 || seeding==14) {
        team.setGroup(groupC);
        teamRepository.save(team);
        } else {
            team.setGroup(groupD);
            teamRepository.save(team);
        }
        if (seeding==1 || seeding==2 || seeding==3 || seeding==4) {
            team.setPlaceInGroup(1);
            teamRepository.save(team);
        } else if (seeding==5 || seeding==6 || seeding==7 || seeding==8) {
            team.setPlaceInGroup(2);
            teamRepository.save(team);
        } else if (seeding==9 || seeding==10 || seeding==11 || seeding==12) {
            team.setPlaceInGroup(3);
            teamRepository.save(team);
        } else {
            team.setPlaceInGroup(4);
            teamRepository.save(team);
        }
    }


    @Override
    public void setFinalStandings () {
        List<Team> teams = teamRepository.findAll();
        for (Team t: teams) {
            String signature = t.getLoserWinerSignature();
            if (signature.equals("1winner")) {
                t.setFinalStanding(1);
            } else if (signature.equals("1loser")) {
                t.setFinalStanding(2);
            } else if (signature.equals("3winner")) {
                t.setFinalStanding(3);
            } else if (signature.equals("3loser")) {
                t.setFinalStanding(4);
            } else if (signature.equals("5winner")) {
                t.setFinalStanding(5);
            } else if (signature.equals("5loser")) {
                t.setFinalStanding(6);
            } else if (signature.equals("7winner")) {
                t.setFinalStanding(7);
            } else if (signature.equals("7loser")) {
                t.setFinalStanding(8);
            } else if (signature.equals("9winner")) {
                t.setFinalStanding(9);
            } else if (signature.equals("9loser")) {
                t.setFinalStanding(10);
            } else if (signature.equals("11winner")) {
                t.setFinalStanding(11);
            } else if (signature.equals("11loser")) {
                t.setFinalStanding(12);
            } else if (signature.equals("13winner")) {
                t.setFinalStanding(13);
            } else if (signature.equals("13loser")) {
                t.setFinalStanding(14);
            } else if (signature.equals("15winner")) {
                t.setFinalStanding(15);
            } else {
                t.setFinalStanding(16);
            }
            teamRepository.save(t);
        }

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

    @Override
    public List<Team> findAllByGroup(Group group) {
        return teamRepository.findAllByGroup(group);
    }

    @Override
    public Team findTeamByGroupAndPlaceInGroup(Group group, int placeInGroup) {
        return teamRepository.findTeamByGroupAndPlaceInGroup(group, placeInGroup);
    }

    @Override
    public Team findTeamByTeamSignature(String singature) {
        return teamRepository.findTeamByLoserWinerSignature(singature);
    }


}
