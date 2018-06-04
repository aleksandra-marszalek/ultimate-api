package pl.coderslab.theultimateapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.theultimateapi.service.GameService;
import pl.coderslab.theultimateapi.service.GroupService;


@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping(path= "/get-groups")
    @ResponseBody
    public String getAllGroups() {
        return groupService.getGroups().toString();
    }
}
