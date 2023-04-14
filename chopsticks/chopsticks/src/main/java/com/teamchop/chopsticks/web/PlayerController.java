package com.teamchop.chopsticks.web;

import com.teamchop.chopsticks.business.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getPlayers(Model model) {
        model.addAttribute("players", this.playerService.getPlayers());
        return "chopsticks-players";
    }
}
