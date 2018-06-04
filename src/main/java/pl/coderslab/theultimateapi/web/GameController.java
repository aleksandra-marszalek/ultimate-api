package pl.coderslab.theultimateapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.theultimateapi.service.GameService;
import pl.coderslab.theultimateapi.service.GameServiceImpl;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping(path= "/")
    @ResponseBody
    public String getAllGames() {
        return gameService.getAllGames().toString();
    }

    @GetMapping(path= "/get-scheduled-games")
    @ResponseBody
    public String getScheduledGames() {
        return gameService.getScheduledGames().toString();
    }

    @GetMapping(path= "/get-finished-games")
    @ResponseBody
    public String getFinishedGames() {
        return gameService.getFinishedGames().toString();
    }


}
