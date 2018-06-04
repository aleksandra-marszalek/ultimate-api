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
import java.util.*;

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

    public void setPlacesAfterGroupStage () {
        List<Group> allGroups = groupRepository.findAll();
        for (Group g: allGroups) {
            List<Team> groupTeams = teamRepository.findAllByGroup(g);
            Team[] groupArray = groupTeams.toArray(new Team[groupTeams.size()]);
            Arrays.sort(groupArray);
            groupArray[0].setPlaceInGroup(4);
            groupArray[1].setPlaceInGroup(3);
            groupArray[2].setPlaceInGroup(2);
            groupArray[3].setPlaceInGroup(1);
            groupRepository.save(g);
        }

    }

    public void addQuarterFinals () {
        Game game1 = new Game();
        Game game2 = new Game();
        Game game3 = new Game();
        Game game4 = new Game();
        Game game5 = new Game();
        Game game6 = new Game();
        Game game7 = new Game();
        Game game8 = new Game();
        game1.setTeam1(getTeamByGroupAndPlace("A", 1));
        game1.setTeam2(getTeamByGroupAndPlace("D", 2));
        game1.setSignature("A1");
        game2.setTeam1(getTeamByGroupAndPlace("B", 1));
        game2.setTeam2(getTeamByGroupAndPlace("C", 2));
        game2.setSignature("B1");
        game3.setTeam1(getTeamByGroupAndPlace("A", 2));
        game3.setTeam2(getTeamByGroupAndPlace("D", 1));
        game3.setSignature("C1");
        game4.setTeam1(getTeamByGroupAndPlace("B", 2));
        game4.setTeam2(getTeamByGroupAndPlace("C", 1));
        game4.setSignature("D1");
        game5.setTeam1(getTeamByGroupAndPlace("A", 3));
        game5.setTeam2(getTeamByGroupAndPlace("D", 4));
        game5.setSignature("A2");
        game6.setTeam1(getTeamByGroupAndPlace("B", 3));
        game6.setTeam2(getTeamByGroupAndPlace("C", 4));
        game6.setSignature("B2");
        game7.setTeam1(getTeamByGroupAndPlace("A", 4));
        game7.setTeam2(getTeamByGroupAndPlace("D", 3));
        game7.setSignature("C2");
        game8.setTeam1(getTeamByGroupAndPlace("B", 4));
        game8.setTeam2(getTeamByGroupAndPlace("C", 3));
        game8.setSignature("D2");
        List<Game> allGames1 = new ArrayList<>();
        List<Game> allGames2 = new ArrayList<>();
        allGames1.add(game1);
        allGames1.add(game2);
        allGames1.add(game3);
        allGames1.add(game4);
        allGames2.add(game5);
        allGames2.add(game6);
        allGames2.add(game7);
        allGames2.add(game8);
        for (Game game: allGames1) {
            game.setOddsForTeam1(getOddsForTeam1(game));
            game.setOddsForTeam2(getOddsForTeam2(game));
            game.setStatus(0);
            LocalDateTime date = LocalDateTime.of(2018, 9, 17, 16, 0);
            game.setGameTime(date);
            gameRepository.save(game);
        }
        for (Game game: allGames2) {
            game.setOddsForTeam1(getOddsForTeam1(game));
            game.setOddsForTeam2(getOddsForTeam2(game));
            game.setStatus(0);
            LocalDateTime date = LocalDateTime.of(2018, 9, 17, 17, 0);
            game.setGameTime(date);
            gameRepository.save(game);
        }




    }

    public Team getTeamByGroupAndPlace(String a, int i) {
        return teamRepository.findTeamByGroupAndPlaceInGroup(groupRepository.findGroupByName(a), i);
    }

    @Override
    public void playGames(LocalDateTime gameTime) {
        List<Game> allPlaned = gameRepository.findAllByStatus(0);
        Random random = new Random();
        for (Game g: allPlaned) {
            if (g.getGameTime().isEqual(gameTime)){
                g.setPointsTeam1(random.nextInt(15));
                g.setPointsTeam2(random.nextInt(15));
                while (g.getPointsTeam1()==g.getPointsTeam2()){
                    g.setPointsTeam2(random.nextInt(15));
                }
                if (g.getPointsTeam1()>g.getPointsTeam2()) {
                    g.getTeam1().setWon(g.getTeam1().getWon()+1);
                    g.getTeam1().setPointBalance(g.getTeam1().getPointBalance()+(g.getPointsTeam1()-g.getPointsTeam2()));
                    g.getTeam2().setLost(g.getTeam2().getLost()+1);
                    g.getTeam2().setPointBalance(g.getTeam2().getPointBalance()-(g.getPointsTeam1()-g.getPointsTeam2()));
                    if (g.getTeam1().getStrength()<g.getTeam2().getStrength()) {
                        g.getTeam1().setStrength((g.getTeam1().getStrength()+g.getTeam2().getStrength())/2.0);
                        g.getTeam2().setStrength((g.getTeam1().getStrength()+g.getTeam2().getStrength())/2.0);
                    }
                } else {
                    g.getTeam2().setWon(g.getTeam2().getWon()+1);
                    g.getTeam2().setPointBalance(g.getTeam2().getPointBalance()+(g.getPointsTeam2()-g.getPointsTeam1()));
                    g.getTeam1().setLost(g.getTeam1().getLost()+1);
                    g.getTeam1().setPointBalance(g.getTeam1().getPointBalance()-(g.getPointsTeam2()-g.getPointsTeam1()));
                    if (g.getTeam1().getStrength()>g.getTeam2().getStrength()) {
                        g.getTeam1().setStrength((g.getTeam1().getStrength()+g.getTeam2().getStrength())/2.0);
                        g.getTeam2().setStrength((g.getTeam1().getStrength()+g.getTeam2().getStrength())/2.0);
                    }
                }
                g.setOddsForTeam1(getOddsForTeam1(g));
                g.setOddsForTeam2(getOddsForTeam2(g));
                teamRepository.save(g.getTeam1());
                teamRepository.save(g.getTeam2());
                g.setStatus(1);
                gameRepository.save(g);
            }
        }

    }

    @Override
    public void playFinals(LocalDateTime gameTime) {
        List<Game> allPlaned = gameRepository.findAllByStatus(0);
        Random random = new Random();
        for (Game g: allPlaned) {
            if (g.getGameTime().isEqual(gameTime)){
                g.setPointsTeam1(random.nextInt(15));
                g.setPointsTeam2(random.nextInt(15));
                while (g.getPointsTeam1()==g.getPointsTeam2()){
                    g.setPointsTeam2(random.nextInt(15));
                }
                if (g.getPointsTeam1()>g.getPointsTeam2()) {
                    g.getTeam1().setWon(g.getTeam1().getWon()+1);
                    g.getTeam1().setPointBalance(g.getTeam1().getPointBalance()+(g.getPointsTeam1()-g.getPointsTeam2()));
                    g.getTeam1().setLoserWinerSignature(g.getSignature()+"winner");
                    g.getTeam2().setLost(g.getTeam2().getLost()+1);
                    g.getTeam2().setPointBalance(g.getTeam2().getPointBalance()-(g.getPointsTeam1()-g.getPointsTeam2()));
                    g.getTeam2().setLoserWinerSignature(g.getSignature()+"loser");
                    if (g.getTeam1().getStrength()<g.getTeam2().getStrength()) {
                        g.getTeam1().setStrength((g.getTeam1().getStrength()+g.getTeam2().getStrength())/2.0);
                        g.getTeam2().setStrength((g.getTeam1().getStrength()+g.getTeam2().getStrength())/2.0);
                    }
                } else {
                    g.getTeam2().setWon(g.getTeam2().getWon()+1);
                    g.getTeam2().setPointBalance(g.getTeam2().getPointBalance()+(g.getPointsTeam2()-g.getPointsTeam1()));
                    g.getTeam2().setLoserWinerSignature(g.getSignature()+"winner");
                    g.getTeam1().setLost(g.getTeam1().getLost()+1);
                    g.getTeam1().setPointBalance(g.getTeam1().getPointBalance()-(g.getPointsTeam2()-g.getPointsTeam1()));
                    g.getTeam1().setLoserWinerSignature(g.getSignature()+"loser");
                    if (g.getTeam1().getStrength()>g.getTeam2().getStrength()) {
                        g.getTeam1().setStrength((g.getTeam1().getStrength()+g.getTeam2().getStrength())/2.0);
                        g.getTeam2().setStrength((g.getTeam1().getStrength()+g.getTeam2().getStrength())/2.0);
                    }
                }

                g.setOddsForTeam1(getOddsForTeam1(g));
                g.setOddsForTeam2(getOddsForTeam2(g));


//                teamRepository.save(g.getTeam1());
//                teamRepository.save(g.getTeam2());
                g.setStatus(1);
                gameRepository.save(g);
            }
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
        List<Game> allGames = gameRepository.findAll();
        newJSONObject(allGames, games);

    }

    public ArrayList<JSONObject> getScheduledGames() {
        return scheduledGames;
    }

    private ArrayList<JSONObject> scheduledGames = new ArrayList<>();

    @Scheduled(fixedRate = 5000)
    public void regenerateScheduled() throws JSONException {
        scheduledGames.clear();
        List<Game> allGames = gameRepository.findAllByStatus(0);
        newJSONObject(allGames, scheduledGames);

    }


    public ArrayList<JSONObject> getFinishedGames() {
        return finishedGames;
    }

    private ArrayList<JSONObject> finishedGames = new ArrayList<>();

    @Scheduled(fixedRate = 5000)
    public void regenerateFinished() throws JSONException {
        finishedGames.clear();
        List<Game> allGames = gameRepository.findAllByStatus(1);
        newJSONObject(allGames, finishedGames);

    }

    public void newJSONObject(List<Game> allGames, ArrayList<JSONObject> games) {
        for (Game g: allGames) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("id", g.getId());
            oJsonInner.put("gameTime", g.getGameTime());
            oJsonInner.put("pointsTeam1", g.getPointsTeam1());
            oJsonInner.put("pointsTeam2", g.getPointsTeam2());
            oJsonInner.put("oddsForTeam1", g.getOddsForTeam1());
            oJsonInner.put("oddsForTeam2", g.getOddsForTeam2());
            oJsonInner.put("status", g.getStatus());
            JSONObject team1 = new JSONObject();
            team1.put("id", g.getTeam1().getId());
            team1.put("name",  g.getTeam1().getName());
            team1.put("seeding", g.getTeam1().getSeeding());
            team1.put("strength", g.getTeam1().getStrength());
            JSONObject team2 = new JSONObject();
            team2.put("id", g.getTeam2().getId());
            team2.put("name",  g.getTeam2().getName());
            team2.put("seeding", g.getTeam2().getSeeding());
            team2.put("strength", g.getTeam2().getStrength());
            oJsonInner.put("team1", team1);
            oJsonInner.put("team2", team2);
            games.add(oJsonInner);
        }
    }


}
