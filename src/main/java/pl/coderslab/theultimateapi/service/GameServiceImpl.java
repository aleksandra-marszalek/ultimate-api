package pl.coderslab.theultimateapi.service;

import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.coderslab.theultimateapi.repository.GameRepository;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    GameRepository gameRepository;

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
