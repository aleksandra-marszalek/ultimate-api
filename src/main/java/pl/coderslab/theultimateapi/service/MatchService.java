package pl.coderslab.theultimateapi.service;

import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class MatchService {

    MatchService() throws JSONException{ this.regenerate();
    }
    public ArrayList<JSONObject> getMatches() {
        return matches;
    }

    private ArrayList<JSONObject> matches = new ArrayList<>();

    @Scheduled(fixedRate = 5000)
    public void regenerate() throws JSONException {
        Faker faker = new Faker(new Locale("pl_PL"));
        matches.clear();
        for (int i = 0; i < 10; i++) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("firstTeam", faker.team().name());
            oJsonInner.put("firstPoints", faker.number().randomDigitNotZero());
            oJsonInner.put("secondTeam", faker.team().name());
            oJsonInner.put("secondPoints", faker.number().randomDigitNotZero());
            matches.add(oJsonInner);
        }
    }




}
