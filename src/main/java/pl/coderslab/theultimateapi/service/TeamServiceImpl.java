package pl.coderslab.theultimateapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.theultimateapi.entity.Team;
import pl.coderslab.theultimateapi.repository.TeamRepository;

import java.util.List;


@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    public void addTeamToDb (String name, double strength, int seeding) {
        Team team = new Team();
        team.setName(name);
        team.setStrength(strength);
        team.setSeeding(seeding);
        teamRepository.save(team);
    }

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
