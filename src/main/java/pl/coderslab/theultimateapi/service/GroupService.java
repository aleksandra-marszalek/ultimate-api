package pl.coderslab.theultimateapi.service;

import pl.coderslab.theultimateapi.entity.Group;
import pl.coderslab.theultimateapi.entity.Team;

import java.util.List;

public interface GroupService {

    public void save(Group group);

    public List<Group> findAll();

    public void addGroupToDb(String name);
}
