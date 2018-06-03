package pl.coderslab.theultimateapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.theultimateapi.entity.Game;
import pl.coderslab.theultimateapi.entity.Team;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByStatus(int status);

    Game findGameById(Long id);

    List<Game> findAllByTeam1(Team team);
    List<Game> findAllByTeam2(Team team);


}
