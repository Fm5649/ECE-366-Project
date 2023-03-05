package com.teamchop.chopsticks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

@RestController
public class Controllers {
    private JsonParser parser = JsonParserFactory.getJsonParser();

    @GetMapping("/getPlayerById/{id}")
    public Player getPlayer(@PathVariable long id) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Player player;
        try {
            Connection connection = dcm.getConnection();
            PlayerDAO playerDAO = new PlayerDAO(connection);

            player = playerDAO.findById(id);
            System.out.println(player);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    @GetMapping("/getPlayerByName/{name}")
    public Player create(@PathVariable String name) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Player player = new Player();
        try {
            Connection connection = dcm.getConnection();
            PlayerDAO PlayerDAO = new PlayerDAO(connection);

            player = PlayerDAO.findByUserName(name);
            System.out.println(player);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    @GetMapping("/getGameById/{id}")
    public Game getGameById(@PathVariable long id) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Game g;
        try {
            Connection connection = dcm.getConnection();
            GameDAO gameDAO = new GameDAO(connection);

            g = gameDAO.findById(id);
            System.out.println(g);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return g;
    }

    @PostMapping(value = "/insertGame")
    public Game insertGame(@RequestBody GameForm message) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Game g;
        try {
            Connection connection = dcm.getConnection();
            GameDAO gameDAO = new GameDAO(connection);
            g = gameDAO.insertGame(message.p1, message.p2);
            System.out.println(g);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return g;
    }

    @GetMapping(value = "/getGameRoundById/{id}")
    public Game getGameRoundById(@PathVariable long id) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        GameRound g;
        try {
            Connection connection = dcm.getConnection();
            GameRoundDAO gameDAO = new GameRoundDAO(connection);

            g = gameDAO.findById(id);
            System.out.println(g);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return g;
    }
    //long gameId, int roundNumber, String playerturn, String playerChoice, String target, int amount, int p1Hand1, int p1Hand2, int p2hand1, int p2Hand2
    @PostMapping(value = "/insertGameRound")
    public GameRound insertGameRound(@RequestBody GameRound message) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        GameRound g;
        try {
            Connection connection = dcm.getConnection();
            GameRoundDAO gameDAO = new GameRoundDAO(connection);

            g = gameDAO.insertGameRound(message.getGameId(),
                    message.getRoundNumber(),
                    message.getPlayerTurn(),
                    message.getPlayerChoice(),
                    message.getPlayerHandUsed(),
                    message.getTarget(),
                    message.getAmount(),
                    message.getP1Hand1(),
                    message.getP1Hand2(),
                    message.getP2Hand1(),
                    message.getP2Hand2());
            System.out.println(g);
        }
        catch(SQLException e) {
            e.printStackTrace();

        }
        return g;
    }

    @GetMapping(value = "/getLeaderboardById/{id}")
    public Leaderboard getLeaderboardById(@PathVariable long id) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Leaderboard l;
        try {
            Connection connection = dcm.getConnection();
            LeaderboardDAO leaderDAO = new LeaderboardDAO(connection);

            l = leaderDAO.findById(message);
            System.out.println(l);
        }
        catch(SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).body("internal server error");
        }
        return ResponseEntity.ok().body(l.toString());
    }
    @PostMapping(value = "/insertLeaderboard")
    public Leaderboard insertLeaderboard(@RequestBody Leaderboard message) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Leaderboard g;
        try {
            Connection connection = dcm.getConnection();
            LeaderboardDAO leaderDAO = new LeaderboardDAO(connection);
            Map<String,Object> msg = parser.parseMap(message);
            g = leaderDAO.insertLeaderboard(message.getRank(),
                    message.getUsername(),
                    message.getWins(),
                    message.getLosses(),
                    message.getTotalGames(),
                    message.getElo(),
                    message.getUserId());
            System.out.println(g);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return g;
    }
}
