package com.teamchop.chopsticks;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.google.rpc.context.AttributeContext;
import com.teamchop.chopsticks.exception.NotFoundException;
import com.teamchop.chopsticks.util.Authenticate;
import org.apache.http.protocol.HTTP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.teamchop.chopsticks.util.Authenticate.*;

import static com.teamchop.chopsticks.GameLogic.getElo;

@RestController
public class Controllers {
    private JsonParser parser = JsonParserFactory.getJsonParser();

    @GetMapping("/getPlayerById/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable long id,@RequestHeader(HttpHeaders.AUTHORIZATION) String idToken) {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Player player = null;
        try {
            Connection connection = dcm.getConnection();
            PlayerDAO playerDAO = new PlayerDAO(connection);

            player = playerDAO.findById(id);
            boolean own = Authenticate.getFirebaseId(idToken).equals(player.getFirebaseId());
            if (!own) player.setPassword("");
            if (player.getId()==0) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            System.out.println(player);
        }
        catch(SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(player,HttpStatus.OK);
    }

    @GetMapping("/getPlayerByName/{name}")
    public ResponseEntity<Player> create(@PathVariable String name, @RequestHeader(HttpHeaders.AUTHORIZATION) String idToken) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Player player = null;
        try {
            Connection connection = dcm.getConnection();
            PlayerDAO PlayerDAO = new PlayerDAO(connection);
            player = PlayerDAO.findByUserName(name);
            boolean own = Authenticate.getFirebaseId(idToken).equals(player.getFirebaseId());
            if (!own) player.setPassword("");
            if (player.getId()==0) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            System.out.println(player);
        }
        catch(SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (player == null) {
            throw new NotFoundException("Player not found");
        }
        return new ResponseEntity<>(player,HttpStatus.OK);
    }

    @GetMapping("/getPlayers")
    public List<Player> getPlayers() {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        List<Player> player = new ArrayList<>();
        try {
            Connection connection = dcm.getConnection();
            PlayerDAO PlayerDAO = new PlayerDAO(connection);

            player = PlayerDAO.getPlayers();
            System.out.println(player);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        if (player == null) {
            throw new NotFoundException("Player not found");
        }
        return player;
    }

    @PostMapping("/insertPlayer")
    public ResponseEntity<Player> create(@RequestBody PlayerForm pForm) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Player player = null;
        try {
            Connection connection = dcm.getConnection();
            PlayerDAO PlayerDAO = new PlayerDAO(connection);
            player = PlayerDAO.insertUserName(pForm.email,pForm.userName, pForm.password,pForm.firebaseId);
            System.out.println(player);
        }
        catch(SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(player,HttpStatus.OK);
    }

    @PostMapping("/updatePlayer")
    public ResponseEntity<Player> create(@RequestBody Player p, @RequestHeader(HttpHeaders.AUTHORIZATION) String idToken) {
        if (!Authenticate.getFirebaseId(idToken).equals(p.getFirebaseId()))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
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
        return new ResponseEntity<>(player, HttpStatus.OK);
    }
    
    @DeleteMapping("/deletePlayerById/{id}")
    public ResponseEntity<Player> deletePlayerById(@PathVariable long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String idToken) {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Player player = null;
        try {
            Connection connection = dcm.getConnection();
            PlayerDAO playerDAO = new PlayerDAO(connection);
            player = playerDAO.findById(id);
            if (!Authenticate.getFirebaseId(idToken).equals(player.getFirebaseId()))
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            player = playerDAO.deleteById(id);
            System.out.println(player);
        }
        catch(SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(player,HttpStatus.OK);
    }

    @GetMapping("/getGameById/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable long id) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Game g = null;
        try {
            Connection connection = dcm.getConnection();
            GameDAO gameDAO = new GameDAO(connection);

            g = gameDAO.findById(id);
            if (g.getId() == 0) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            System.out.println(g);
        }
        catch(SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(g,HttpStatus.OK);
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

    @GetMapping("/getAvailableGames/{id}")
    public List<Game> getAvailableGames(@PathVariable long id) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        List<Game> g = new ArrayList<>();
        try {
            Connection connection = dcm.getConnection();
            GameDAO gameDAO = new GameDAO(connection);

            g = gameDAO.getAvailableGames(id);
            System.out.println(g);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return g;
    }

    @GetMapping("/getOngoingGames/{id}")
    public List<Game> getOngoingGames(@PathVariable long id) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        List<Game> g = new ArrayList<>();
        try {
            Connection connection = dcm.getConnection();
            GameDAO gameDAO = new GameDAO(connection);

            g = gameDAO.getOngoingGames(id);
            System.out.println(g);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return g;
    }

    @PostMapping(value = "/insertGame")
    public ResponseEntity<Game> insertGame(@RequestBody GameForm message,@RequestHeader(HttpHeaders.AUTHORIZATION) String idToken) {
        if (!Authenticate.validate(idToken))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
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
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(g,HttpStatus.OK);
    }

    @GetMapping(value = "/getGameRoundById/{id}")
    public GameRound getGameRoundById(@PathVariable long id) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        GameRound g=new GameRound();
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
    @GetMapping(value = "/getGameRoundsById/{id}")
    public List<GameRound> getGameRoundsById(@PathVariable long id) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        List<GameRound> g = new ArrayList<>();
        try {
            Connection connection = dcm.getConnection();
            GameRoundDAO gameDAO = new GameRoundDAO(connection);

            g = gameDAO.getAllRounds(id);
            System.out.println(g.size());
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return g;
    }
    //long gameId, int roundNumber, String playerturn, String playerChoice, String target, int amount, int p1Hand1, int p1Hand2, int p2hand1, int p2Hand2

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
    public ResponseEntity<Leaderboard> insertLeaderboard(@RequestBody Leaderboard message, @RequestHeader(HttpHeaders.AUTHORIZATION) String idToken) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        if (!Authenticate.validate(idToken))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
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
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(g,HttpStatus.OK);
    }
}
