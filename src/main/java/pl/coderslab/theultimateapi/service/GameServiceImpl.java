package pl.coderslab.theultimateapi.service;

import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.coderslab.theultimateapi.entity.Game;
import pl.coderslab.theultimateapi.entity.Team;
import pl.coderslab.theultimateapi.repository.GameRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    GameRepository gameRepository;

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


//    GameServiceImpl() throws JSONException{ this.regenerate();
//    }
//    public ArrayList<JSONObject> getMatches() {
//        return games;
//    }
//
//    private ArrayList<JSONObject> games = new ArrayList<>();
//
//    @Scheduled(fixedRate = 5000)
//    public void regenerate() throws JSONException {
//        Faker faker = new Faker(new Locale("pl_PL"));
//        games.clear();
//        for (int i = 0; i < 10; i++) {
//            JSONObject oJsonInner = new JSONObject();
//            oJsonInner.put("firstTeam", faker.team().name());
//            oJsonInner.put("firstPoints", faker.number().randomDigitNotZero());
//            oJsonInner.put("secondTeam", faker.team().name());
//            oJsonInner.put("secondPoints", faker.number().randomDigitNotZero());
//            games.add(oJsonInner);
//        }
//    }




}
