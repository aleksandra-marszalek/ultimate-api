package pl.coderslab.theultimateapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.theultimateapi.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findTeamById(Long id);

}
