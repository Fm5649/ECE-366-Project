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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class Controllers {
    private JsonParser parser = JsonParserFactory.getJsonParser();

    @GetMapping("/getPlayerById/{id}")
    public Player getPlayer(@PathVariable long id) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Player player = null;
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

    @PostMapping("/insertPlayer")
    public Player create(@RequestBody PlayerForm pForm) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Player player = new Player();
        try {
            Connection connection = dcm.getConnection();
            PlayerDAO PlayerDAO = new PlayerDAO(connection);

            player = PlayerDAO.insertUserName(pForm.email,pForm.userName, pForm.password);
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
    
    @DeleteMapping("/deletePlayerById/{id}")
    public Player deletePlayerById(@PathVariable long id) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Player player = null;
        try {
            Connection connection = dcm.getConnection();
            PlayerDAO playerDAO = new PlayerDAO(connection);

            player = playerDAO.deleteById(id);
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
        Game g = null;
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

    @GetMapping("/getGameByPlayerId/{id}")
    public List<Game> getGameByPlayerId(@PathVariable long id) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        List<Game> g = new ArrayList<>();
        try {
            Connection connection = dcm.getConnection();
            GameDAO gameDAO = new GameDAO(connection);

            g = gameDAO.findByPlayerId(id);
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
        Game g = null;
        try {
            Connection connection = dcm.getConnection();
            GameDAO gameDAO = new GameDAO(connection);
            System.out.println(message.p1);
            g = gameDAO.insertGame(message.p1, message.p2);
            System.out.println(g);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return g;
    }

    @PostMapping("/updateHands")
    public GameRound create(@RequestBody GameRound g) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        GameRound gameRound = new GameRound();
        try {
            Connection connection = dcm.getConnection();
            GameRoundDAO GameRoundDAO = new GameRoundDAO(connection);

            g = GameRoundDAO.updateHands(g);
            System.out.println(g);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return gameRound;
    }

    @PostMapping(value = "/getGameRoundById/{id}")
    public GameRound getGameRoundById(@PathVariable long id) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        GameRound g=null;
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
        GameRound g=null;
        try {
            Connection connection = dcm.getConnection();
            GameRoundDAO gameDAO = new GameRoundDAO(connection);
            if (GameLogic.isValidMove(message)) {
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
            }
            int a = GameLogic.winner(message);
            if (a > 0) {
                Game game = null;
                GameDAO gDAO = new GameDAO(connection);
                game = gDAO.findById(g.getGameId());
                System.out.println(game);
                game.setWinner(a == 1 ? game.getPlayerOneId() : game.getPlayerTwoId());
                System.out.println("Winner: "+ game.getWinner());
                gDAO.updateWinner(game.getGameId(),game.getWinner());
            }
            System.out.println(g);

        }
        catch(SQLException e) {
            e.printStackTrace();

        }
        return g;
    }

    @PostMapping(value = "/getValidMoves")
    public List<List<Integer>> getValidMoves(@RequestBody GameRound g) {
        List<List<Integer>> m = null;
        System.out.println(g);
        m = GameLogic.validMoves(g);
        return m;
    }
    @GetMapping(value = "/getLeaderboardById/{id}")
    public Leaderboard getLeaderboardById(@PathVariable long id) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Leaderboard l=null;
        try {
            Connection connection = dcm.getConnection();
            LeaderboardDAO leaderDAO = new LeaderboardDAO(connection);

            l = leaderDAO.findById(id);
            System.out.println(l);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return l;
    }
    @PostMapping(value = "/insertLeaderboard")
    public Leaderboard insertLeaderboard(@RequestBody Leaderboard message) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Leaderboard g=null;
        try {
            Connection connection = dcm.getConnection();
            LeaderboardDAO leaderDAO = new LeaderboardDAO(connection);
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
