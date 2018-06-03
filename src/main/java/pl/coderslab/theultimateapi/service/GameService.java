package pl.coderslab.theultimateapi.service;

import pl.coderslab.theultimateapi.entity.Game;
import pl.coderslab.theultimateapi.entity.Team;

import java.util.List;

public interface GameService {

    public List<Game> findAll();

    public List<Game> findAllPlanned();

    public List<Game> findAllFinished();

    public Game findById(Long id);

    public void save(Game game);

    public void saveAll(List<Game> games);

    public List<Game> findAllByTeam(Team team);
}
