package pl.coderslab.theultimateapi.service;

import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.coderslab.theultimateapi.entity.Game;
import pl.coderslab.theultimateapi.entity.Group;
import pl.coderslab.theultimateapi.entity.Team;
import pl.coderslab.theultimateapi.repository.GameRepository;
import pl.coderslab.theultimateapi.repository.GroupRepository;
import pl.coderslab.theultimateapi.repository.TeamRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    GameRepository gameRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    GroupRepository groupRepository;

    /////////// initial //////////////


    public double getOddsForTeam2(Game game1) {
        return game1.getTeam2().getStrength()/(game1.getTeam1().getStrength()+game1.getTeam2().getStrength());
    }

    public double getOddsForTeam1(Game game) {
        return game.getTeam1().getStrength()/(game.getTeam1().getStrength()+game.getTeam2().getStrength());
    }

    @Override
    public void addFirstGroupGames() {
        for (Group g: groupRepository.findAll()) {
            Game game1 = new Game();
            Game game2 = new Game();
            List<Team> groupTeams = g.getTeams();
            for (Team t: groupTeams) {
                if (t.getPlaceInGroup()==1) {
                    game1.setTeam1(t);
                } else if (t.getPlaceInGroup()==2) {
                    game2.setTeam1(t);
                } else if (t.getPlaceInGroup()==3) {
                    game2.setTeam2(t);
                } else {
                    game1.setTeam2(t);
                }
            }
            game1.setOddsForTeam1(getOddsForTeam1(game1));
            game1.setOddsForTeam2(getOddsForTeam2(game1));
            game2.setOddsForTeam1(getOddsForTeam1(game2));
            game2.setOddsForTeam2(getOddsForTeam2(game2));
            game1.setStatus(0);
            game2.setStatus(0);
            LocalDateTime date = LocalDateTime.of(2018, 9, 17, 8, 0);
            LocalDateTime date2 = LocalDateTime.of(2018, 9, 17, 9, 0);
            game1.setGameTime(date);
            game2.setGameTime(date2);
            gameRepository.save(game1);
            gameRepository.save(game2);
        }
    }

    @Override
    public void addSecondGroupGames() {
        for (Group g: groupRepository.findAll()) {
            Game game1 = new Game();
            Game game2 = new Game();
            List<Team> groupTeams = g.getTeams();
            for (Team t: groupTeams) {
                if (t.getPlaceInGroup()==1) {
                    game1.setTeam1(t);
                } else if (t.getPlaceInGroup()==2) {
                    game2.setTeam1(t);
                } else if (t.getPlaceInGroup()==3) {
                    game1.setTeam2(t);
                } else {
                    game2.setTeam2(t);
                }
            }
            game1.setOddsForTeam1(getOddsForTeam1(game1));
            game1.setOddsForTeam2(getOddsForTeam2(game1));
            game2.setOddsForTeam1(getOddsForTeam1(game2));
            game2.setOddsForTeam2(getOddsForTeam2(game2));
            game1.setStatus(0);
            game2.setStatus(0);
            LocalDateTime date = LocalDateTime.of(2018, 9, 17, 10, 0);
            LocalDateTime date2 = LocalDateTime.of(2018, 9, 17, 11, 0);
            game1.setGameTime(date);
            game2.setGameTime(date2);
            gameRepository.save(game1);
            gameRepository.save(game2);
        }
    }

    @Override
    public void addThirdGroupGames() {
        for (Group g: groupRepository.findAll()) {
            Game game1 = new Game();
            Game game2 = new Game();
            List<Team> groupTeams = g.getTeams();
            for (Team t: groupTeams) {
                if (t.getPlaceInGroup()==1) {
                    game1.setTeam1(t);
                } else if (t.getPlaceInGroup()==2) {
                    game1.setTeam2(t);
                } else if (t.getPlaceInGroup()==3) {
                    game2.setTeam1(t);
                } else {
                    game2.setTeam2(t);
                }
            }
            game1.setOddsForTeam1(getOddsForTeam1(game1));
            game1.setOddsForTeam2(getOddsForTeam2(game1));
            game2.setOddsForTeam1(getOddsForTeam1(game2));
            game2.setOddsForTeam2(getOddsForTeam2(game2));
            game1.setStatus(0);
            game2.setStatus(0);
            LocalDateTime date = LocalDateTime.of(2018, 9, 17, 12, 0);
            LocalDateTime date2 = LocalDateTime.of(2018, 9, 17, 13, 0);
            game1.setGameTime(date);
            game2.setGameTime(date2);
            gameRepository.save(game1);
            gameRepository.save(game2);
        }
    }


    /////////// crud ///////////////

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public List<Game> findAllPlanned() {
        return gameRepository.findAllByStatus(0);
    }

    @Override
    public List<Game> findAllFinished() {
        return gameRepository.findAllByStatus(1);
    }

    @Override
    public Game findById(Long id) {
        return gameRepository.findGameById(id);
    }

    @Override
    public void save(Game game) {
        gameRepository.save(game);
    }

    @Override
    public void saveAll(List<Game> games) {
        for (Game g: games) {
            gameRepository.save(g);
        }
    }

    @Override
    public List<Game> findAllByTeam(Team team) {
        List<Game> allGames = new ArrayList<>();
        for (Game g: gameRepository.findAllByTeam1(team)) {
            allGames.add(g);
        }
        for (Game g: gameRepository.findAllByTeam2(team)) {
            allGames.add(g);
        }
        return allGames;
    }


    //////////// to api ///////////////
    
    public ArrayList<JSONObject> getAllGames() {
        return games;
    }

    private ArrayList<JSONObject> games = new ArrayList<>();

    @Scheduled(fixedRate = 5000)
    public void regenerate() throws JSONException {
        games.clear();
//        List<Team> allTeams = teamRepository.findAll();
//        for (Team t: allTeams) {
//            JSONObject oJsonInner = new JSONObject();
//            oJsonInner.put("id", t.getId());
//            oJsonInner.put("name", t.getName());
//            oJsonInner.put("seeding", t.getSeeding());
//            oJsonInner.put("strength", t.getStrength());
//            teams.add(oJsonInner);
//        }
        List<Game> allGames = gameRepository.findAll();
        for (Game g: allGames) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("id", g.getId());
            oJsonInner.put("gameTime", g.getGameTime());
            oJsonInner.put("pointsTeam1", g.getPointsTeam1());
            oJsonInner.put("pointsTeam2", g.getPointsTeam2());
            oJsonInner.put("oddsForTeam1", g.getOddsForTeam1());
            oJsonInner.put("oddsForTeam2", g.getOddsForTeam2());
            oJsonInner.put("status", g.getStatus());
            oJsonInner.put("team1", g.getTeam1());
            oJsonInner.put("team2", g.getTeam2());
            games.add(oJsonInner);
        }
//        for (int i = 0; i < 10; i++) {
//            JSONObject oJsonInner = new JSONObject();
//            oJsonInner.put("firstTeam", faker.team().name());
//            oJsonInner.put("firstPoints", faker.number().randomDigitNotZero());
//            oJsonInner.put("secondTeam", faker.team().name());
//            oJsonInner.put("secondPoints", faker.number().randomDigitNotZero());
//            games.add(oJsonInner);
//        }
    }




}
