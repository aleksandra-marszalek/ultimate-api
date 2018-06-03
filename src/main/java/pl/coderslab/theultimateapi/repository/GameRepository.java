package pl.coderslab.theultimateapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.theultimateapi.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {


}
