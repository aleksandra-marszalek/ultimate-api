package pl.coderslab.theultimateapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.theultimateapi.service.GroupService;
import pl.coderslab.theultimateapi.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @Autowired
    GroupService groupService;


    @GetMapping("/")
    @ResponseBody
    public String getTeams() {
        return teamService.getTeams().toString();
    }


}
