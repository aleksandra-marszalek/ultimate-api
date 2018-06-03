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
