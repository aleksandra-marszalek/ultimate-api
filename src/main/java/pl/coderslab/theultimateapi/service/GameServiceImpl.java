package pl.coderslab.theultimateapi.service;


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

    public void setGames (LocalDateTime date1, LocalDateTime date2) {

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
        LocalDateTime date1 = LocalDateTime.of(2018, 9, 17, 16, 0);
        LocalDateTime date2 = LocalDateTime.of(2018, 9, 17, 17, 0);
        setOddsStatusDates(allGames1, allGames2, date1, date2);
    }

    public void setOddsStatusDates(List<Game> allGames1, List<Game> allGames2, LocalDateTime dateTime, LocalDateTime dateTime2) {
        setOddsStatusDatesMethod(allGames1, dateTime);
        setOddsStatusDatesMethod(allGames2, dateTime2);
    }

    public void setOddsStatusDatesMethod(List<Game> allGames, LocalDateTime dateTime) {
        for (Game game: allGames) {
            game.setOddsForTeam1(getOddsForTeam1(game));
            game.setOddsForTeam2(getOddsForTeam2(game));
            game.setStatus(0);
            game.setGameTime(dateTime);
            gameRepository.save(game);
        }
    }


    @Override
    public void addSemiFinals () {
        Game game1 = new Game();
        Game game2 = new Game();
        Game game3 = new Game();
        Game game4 = new Game();
        Game game5 = new Game();
        Game game6 = new Game();
        Game game7 = new Game();
        Game game8 = new Game();
        game1.setTeam1(teamRepository.findTeamByLoserWinerSignature("A1winner"));
        game1.setTeam2(teamRepository.findTeamByLoserWinerSignature("C1winner"));
        game1.setSignature("A1");
        game2.setTeam1(teamRepository.findTeamByLoserWinerSignature("B1winner"));
        game2.setTeam2(teamRepository.findTeamByLoserWinerSignature("D1winner"));
        game2.setSignature("B1");
        game3.setTeam1(teamRepository.findTeamByLoserWinerSignature("A1loser"));
        game3.setTeam2(teamRepository.findTeamByLoserWinerSignature("C1loser"));
        game3.setSignature("A2");
        game4.setTeam1(teamRepository.findTeamByLoserWinerSignature("B1loser"));
        game4.setTeam2(teamRepository.findTeamByLoserWinerSignature("D1loser"));
        game4.setSignature("B2");
        game5.setTeam1(teamRepository.findTeamByLoserWinerSignature("A2winner"));
        game5.setTeam2(teamRepository.findTeamByLoserWinerSignature("C2winner"));
        game5.setSignature("A3");
        game6.setTeam1(teamRepository.findTeamByLoserWinerSignature("B2winner"));
        game6.setTeam2(teamRepository.findTeamByLoserWinerSignature("D2winner"));
        game6.setSignature("B3");
        game7.setTeam1(teamRepository.findTeamByLoserWinerSignature("A2loser"));
        game7.setTeam2(teamRepository.findTeamByLoserWinerSignature("C2loser"));
        game7.setSignature("A4");
        game8.setTeam1(teamRepository.findTeamByLoserWinerSignature("B2loser"));
        game8.setTeam2(teamRepository.findTeamByLoserWinerSignature("D2loser"));
        game8.setSignature("B4");
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
        LocalDateTime date1 = LocalDateTime.of(2018, 9, 18, 11, 0);
        LocalDateTime date2 = LocalDateTime.of(2018, 9, 18, 10, 0);
        setOddsStatusDates(allGames1, allGames2, date1, date2);
    }

    @Override
    public void addFinals () {
        Game game1 = new Game();
        Game game2 = new Game();
        Game game3 = new Game();
        Game game4 = new Game();
        Game game5 = new Game();
        Game game6 = new Game();
        Game game7 = new Game();
        Game game8 = new Game();
        game1.setTeam1(teamRepository.findTeamByLoserWinerSignature("A1winner"));
        game1.setTeam2(teamRepository.findTeamByLoserWinerSignature("B1winner"));
        game1.setSignature("1");
        game2.setTeam1(teamRepository.findTeamByLoserWinerSignature("A1loser"));
        game2.setTeam2(teamRepository.findTeamByLoserWinerSignature("B1loser"));
        game2.setSignature("3");
        game3.setTeam1(teamRepository.findTeamByLoserWinerSignature("A2winner"));
        game3.setTeam2(teamRepository.findTeamByLoserWinerSignature("B2winner"));
        game3.setSignature("5");
        game4.setTeam1(teamRepository.findTeamByLoserWinerSignature("A2loser"));
        game4.setTeam2(teamRepository.findTeamByLoserWinerSignature("B2loser"));
        game4.setSignature("7");
        game5.setTeam1(teamRepository.findTeamByLoserWinerSignature("A3winner"));
        game5.setTeam2(teamRepository.findTeamByLoserWinerSignature("B3winner"));
        game5.setSignature("9");
        game6.setTeam1(teamRepository.findTeamByLoserWinerSignature("A3loser"));
        game6.setTeam2(teamRepository.findTeamByLoserWinerSignature("B3loser"));
        game6.setSignature("11");
        game7.setTeam1(teamRepository.findTeamByLoserWinerSignature("A4winner"));
        game7.setTeam2(teamRepository.findTeamByLoserWinerSignature("B4winner"));
        game7.setSignature("13");
        game8.setTeam1(teamRepository.findTeamByLoserWinerSignature("A4loser"));
        game8.setTeam2(teamRepository.findTeamByLoserWinerSignature("B4loser"));
        game8.setSignature("15");
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
        LocalDateTime date1 = LocalDateTime.of(2018, 9, 18, 14, 0);
        LocalDateTime date2 = LocalDateTime.of(2018, 9, 18, 13, 0);
        setOddsStatusDates(allGames1, allGames2, date1, date2);
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
            oJsonInner.put("signature", g.getSignature());
            oJsonInner.put("team1_id", g.getTeam1().getId());
            oJsonInner.put("team2_id", g.getTeam2().getId());
//            JSONObject team1 = new JSONObject();
//            team1.put("id", g.getTeam1().getId());
//            team1.put("name", g.getTeam1().getName());
//            team1.put("seeding", g.getTeam1().getSeeding());
//            team1.put("strength", g.getTeam1().getStrength());
//            team1.put("group", g.getTeam1().getGroup().getName());
//            team1.put("placeInGroup", g.getTeam1().getPlaceInGroup());
//            team1.put("won", g.getTeam1().getWon());
//            team1.put("lost", g.getTeam1().getLost());
//            team1.put("pointBalance", g.getTeam1().getPointBalance());
//            team1.put("finalStanding", g.getTeam1().getFinalStanding());
//            JSONObject team2 = new JSONObject();
//            team2.put("id", g.getTeam2().getId());
//            team2.put("name", g.getTeam2().getName());
//            team2.put("seeding", g.getTeam2().getSeeding());
//            team2.put("strength", g.getTeam2().getStrength());
//            team2.put("group", g.getTeam2().getGroup().getName());
//            team2.put("placeInGroup", g.getTeam2().getPlaceInGroup());
//            team2.put("won", g.getTeam2().getWon());
//            team2.put("lost", g.getTeam2().getLost());
//            team2.put("pointBalance", g.getTeam2().getPointBalance());
//            team2.put("finalStanding", g.getTeam2().getFinalStanding());
//            oJsonInner.put("team1", team1);
//            oJsonInner.put("team2", team2);
            games.add(oJsonInner);
        }
    }


}
