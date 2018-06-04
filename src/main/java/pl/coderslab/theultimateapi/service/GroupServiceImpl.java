package pl.coderslab.theultimateapi.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.coderslab.theultimateapi.entity.Group;
import pl.coderslab.theultimateapi.entity.Team;
import pl.coderslab.theultimateapi.repository.GroupRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    /////////////// to api ///////////////

    public ArrayList<JSONObject> getGroups() {
        return groups;
    }

    private ArrayList<JSONObject> groups = new ArrayList<>();

    @Scheduled(fixedRate = 5000)
    public void regenerate() throws JSONException {
        groups.clear();
        List<Group> allGroups = groupRepository.findAll();
        for (Group g: allGroups) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("id", g.getId());
            oJsonInner.put("name", g.getName());
            for (int i=0; i<g.getTeams().size(); i++) {
                JSONObject team = new JSONObject();
                Team t = g.getTeams().get(i);
                team.put("id", t.getId());
                team.put("name", t.getName());
                team.put("seeding", t.getSeeding());
                team.put("strength", t.getStrength());
                team.put("group", t.getGroup().getName());
                team.put("placeInGroup", t.getPlaceInGroup());
                team.put("won", t.getWon());
                team.put("lost", t.getLost());
                team.put("pointBalance", t.getPointBalance());
                team.put("finalStanding", t.getFinalStanding());
                oJsonInner.put("team"+(i+1), team);
            }
            groups.add(oJsonInner);
        }
    }



    /////////////// crud /////////////////

    @Override
    public void save(Group group) {
        groupRepository.save(group);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }


    //////////// init //////////////////
    @Override
    public void addGroupToDb(String name) {
        Group group = new Group();
        group.setName(name);
        groupRepository.save(group);
    }

}
