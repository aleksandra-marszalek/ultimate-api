package pl.coderslab.theultimateapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.theultimateapi.entity.Team;
import pl.coderslab.theultimateapi.service.GameService;
import pl.coderslab.theultimateapi.service.GroupService;
import pl.coderslab.theultimateapi.service.TeamService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/init")
public class InitialController {

    @Autowired
    TeamService teamService;

    @Autowired
    GroupService groupService;

    @Autowired
    GameService gameService;

    @GetMapping("/addTeams")
    @ResponseBody
    public String addTeams () {
        teamService.addTeamToDb("Grandmaster Flash Warszawa", 16.0, 1);
        teamService.addTeamToDb("KWR Knury Kamieniec Wrocławski", 15.0, 2);
        teamService.addTeamToDb("muJAHedini dysku Warszawa", 14.0, 3);
        teamService.addTeamToDb("KS AZS AWF Flow Wrocław", 13.0, 4);
        teamService.addTeamToDb("Zawierucha Warszawa", 12.0, 5);
        teamService.addTeamToDb("RJP Warszawa", 11.0, 6);
        teamService.addTeamToDb("KS BC Kosmodysk Warszawa", 10.0, 7);
        teamService.addTeamToDb("Kato Vice Katowice", 9.0, 8);
        teamService.addTeamToDb("4hands Warszawa", 8.0, 9);
        teamService.addTeamToDb("KrakUF Kraków", 7.0, 10);
        teamService.addTeamToDb("Uwaga Pies Poznań", 6.0, 11);
        teamService.addTeamToDb("KS Nine Hills Chełmno", 5.0, 12);
        teamService.addTeamToDb("Frisbnik Rybnik", 4.0, 13);
        teamService.addTeamToDb("Brave Beavers Dopiewo", 3.0, 14);
        teamService.addTeamToDb("Ultimatum Gdańsk", 2.0, 15);
        teamService.addTeamToDb("Mad Hatters MOSiR Płock", 1.0, 16);
        return "Teams added";
    }

    @GetMapping("/addGroups")
    @ResponseBody
    public String addGroups () {
        groupService.addGroupToDb("A");
        groupService.addGroupToDb("B");
        groupService.addGroupToDb("C");
        groupService.addGroupToDb("D");
        return "Groups added";
    }

    @GetMapping("/addTeamsToGroups")
    @ResponseBody
    public String addTeamsToGroups () {
        List<Team> teams = teamService.findAll();
        for (Team t: teams) {
            teamService.addToGroupBySeeding(t);
        }
        return "Teams added to groups";
    }

    @GetMapping("/addFirstGroupGames")
    @ResponseBody
    public String addFirstGroupGames () {
        gameService.addFirstGroupGames();
        return "First group games added to schedule";
    }

    @GetMapping("/addSecondGroupGames")
    @ResponseBody
    public String addSecondGroupGames () {
        gameService.addSecondGroupGames();
        return "Second group games added to schedule";
    }

    @GetMapping("/addThirdGroupGames")
    @ResponseBody
    public String addThirdGroupGames () {
        gameService.addThirdGroupGames();
        return "Third group games added to schedule";
    }

    @GetMapping("/playGames/saturday/{hourOfGame}")
    @ResponseBody
    public String playGames(@PathVariable String hourOfGame) {
        Integer hour = Integer.parseInt(hourOfGame);
        LocalDateTime gameTime = LocalDateTime.of(2018, 9, 17, hour, 0);
        gameService.playGames(gameTime);
        return "Games have been played";
    }

    @GetMapping("setPlacesInGroups")
    @ResponseBody
    public String setPlacesInGroups () {
        gameService.setPlacesAfterGroupStage();
        return "The places has been set";
    }

    @GetMapping("/addQuarterFinals")
    @ResponseBody
    public String addQuarterFinals () {
        gameService.addQuarterFinals();
        return "Quarterfinal games added to schedule";
    }



}
