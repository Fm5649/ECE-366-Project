package com.teamchop.chopsticks.webservice;

import com.teamchop.chopsticks.DatabaseConnectionManager;
import com.teamchop.chopsticks.Player;
import com.teamchop.chopsticks.PlayerDAO;
import com.teamchop.chopsticks.business.PlayerService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebserviceController {
    private final PlayerService playerService;

    public WebserviceController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @CrossOrigin
    @GetMapping("/getPlayers")
    public List<Player> getPlayers(){
        System.out.println("getPlayers");
        return this.playerService.getPlayers();
    }

    @PostMapping("/findById")
    public Player create(@RequestBody String message) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "rps", "postgres", "password");
        Player player = new Player();
        try {
            Connection connection = dcm.getConnection();
            PlayerDAO playerDAO = new PlayerDAO(connection);

            player = playerDAO.findById(Integer.parseInt(message));
            System.out.println(player);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    @PostMapping("/updatePlayer")
    public Player create(@RequestBody Player p) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Player player = new Player();
        try {
            Connection connection = dcm.getConnection();
            PlayerDAO PlayerDAO = new PlayerDAO(connection);

            player = PlayerDAO.updateStats(p);
            System.out.println(player);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

}