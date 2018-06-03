package pl.coderslab.theultimateapi.service;

import org.json.JSONObject;
import pl.coderslab.theultimateapi.entity.Group;
import pl.coderslab.theultimateapi.entity.Team;

import java.util.ArrayList;
import java.util.List;

public interface GroupService {

    public void save(Group group);

    public List<Group> findAll();

    public void addGroupToDb(String name);

}
