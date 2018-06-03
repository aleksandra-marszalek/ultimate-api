package pl.coderslab.theultimateapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.theultimateapi.entity.Group;
import pl.coderslab.theultimateapi.entity.Team;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findTeamById(Long id);

    List<Team> findAllByGroup(Group group);

}
