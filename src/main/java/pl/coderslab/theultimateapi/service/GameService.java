package pl.coderslab.theultimateapi.service;

import org.json.JSONObject;
import pl.coderslab.theultimateapi.entity.Game;
import pl.coderslab.theultimateapi.entity.Team;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface GameService {

    public List<Game> findAll();

    public List<Game> findAllPlanned();

    public List<Game> findAllFinished();

    public Game findById(Long id);

    public void save(Game game);

    public void saveAll(List<Game> games);

    public List<Game> findAllByTeam(Team team);

    public void addFirstGroupGames ();

    public void addSecondGroupGames ();

    public void addThirdGroupGames ();

    public ArrayList<JSONObject> getAllGames();

    public void playGames(LocalDateTime gameTime);

}
