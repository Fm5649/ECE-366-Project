package com.chopsticks.lil.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

@SpringBootApplication
@RestController
public class Chopstick {
	private JsonParser parser = JsonParserFactory.getJsonParser();
	@PostMapping("/getPlayerById")
	public ResponseEntity<String> getPlayer(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		Player player = new Player();
		try {
			Connection connection = dcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);

			player = playerDAO.findById(Integer.parseInt(message));
			System.out.println(player);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return ResponseEntity.status(404).body("internal server error");
		}
		return ResponseEntity.ok().body(player.toString());
	}

    @PostMapping("/getPlayerByName")
	public ResponseEntity<String> create(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		Player player = new Player();
		try {
			Connection connection = dcm.getConnection();
			PlayerDAO PlayerDAO = new PlayerDAO(connection);

			player = PlayerDAO.findById(Long.parseLong(message));
			System.out.println(player);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return ResponseEntity.status(404).body("internal server error");
		}
		return ResponseEntity.ok().body(player.toString());
	}

    @PostMapping("/getGameById")
	public ResponseEntity<String> getGameById(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		Game g;
		try {
			Connection connection = dcm.getConnection();
			GameDAO gameDAO = new GameDAO(connection);

			g = gameDAO.findById(Integer.parseInt(message));
            System.out.println(g);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return ResponseEntity.status(404).body("internal server error");
		}
		return ResponseEntity.ok().body(g.toString());
	}

    @PostMapping(value = "/insertGame")
	public ResponseEntity<String> insertGame(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		Game g;
		try {
			Connection connection = dcm.getConnection();
			GameDAO gameDAO = new GameDAO(connection);
			Map<String, Object> msg = parser.parseMap(message);
			g = gameDAO.insertGame(Long.parseLong((String) msg.get("p1")), Long.parseLong((String) msg.get("p2")));
            System.out.println(g);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return ResponseEntity.status(404).body("internal server error");
		}
		return ResponseEntity.ok().body(g.toString());
	}

    @PostMapping(value = "/getGameRoundById")
	public ResponseEntity<String> getGameRoundById(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		GameRound g;
		try {
			Connection connection = dcm.getConnection();
			GameRoundDAO gameDAO = new GameRoundDAO(connection);

			g = gameDAO.findById(Integer.parseInt(message));
            System.out.println(g);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return ResponseEntity.status(404).body("internal server error");
		}
		return ResponseEntity.ok().body(g.toString());
	}
    //long gameId, int roundNumber, String playerturn, String playerChoice, String target, int amount, int p1Hand1, int p1Hand2, int p2hand1, int p2Hand2
    @PostMapping(value = "/insertGameRound")
	public ResponseEntity<String> insertGameRound(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		GameRound g;
		try {
			Connection connection = dcm.getConnection();
			GameRoundDAO gameDAO = new GameRoundDAO(connection);
			Map<String, Object> msg = parser.parseMap(message);

			g = gameDAO.insertGameRound(Long.parseLong((String) msg.get("gameId")),
            Integer.parseInt((String) msg.get("roundNumber")),
					(String) msg.get("playerturn"),
					(String) msg.get("playerChoice"),
					(String) msg.get("playerHandUsed"),
					(String) msg.get("target"),
            Integer.parseInt((String) msg.get("amount")),
            Integer.parseInt((String) msg.get("p1Hand1")),
            Integer.parseInt((String) msg.get("p1Hand2")),
            Integer.parseInt((String) msg.get("p2Hand1")),
            Integer.parseInt((String) msg.get("p2Hand2")));
            System.out.println(g);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return ResponseEntity.status(404).body("internal server error");
		}
		return ResponseEntity.ok().body(g.toString());
	}

    @PostMapping(value = "/getLeaderboardById")
	public ResponseEntity<String> getLeaderboardById(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		Leaderboard l;
		try {
			Connection connection = dcm.getConnection();
			LeaderboardDAO leaderDAO = new LeaderboardDAO(connection);

			l = leaderDAO.findById(Integer.parseInt(message));
            System.out.println(l);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return ResponseEntity.status(404).body("internal server error");
		}
		return ResponseEntity.ok().body(l.toString());
	}
    @PostMapping(value = "/insertLeaderboard")
	public ResponseEntity<String> insertLeaderboard(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		Leaderboard g;
		try {
			Connection connection = dcm.getConnection();
			LeaderboardDAO leaderDAO = new LeaderboardDAO(connection);
			Map<String,Object> msg = parser.parseMap(message);
			g = leaderDAO.insertLeaderboard(Integer.parseInt((String) msg.get("rank")),
					(String) msg.get("amount"),
            Integer.parseInt((String) msg.get("wins")),
            Integer.parseInt((String) msg.get("losses")),
            Integer.parseInt((String) msg.get("totalGames")),
            Integer.parseInt((String) msg.get("elo")),
            Long.parseLong((String) msg.get("userId")));
            System.out.println(g);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return ResponseEntity.status(404).body("internal server error");
		}
		return ResponseEntity.ok().body(g.toString());
	}

	public static void main(String[] args) {
		System.out.println("Hello!");

		SpringApplication.run(Chopstick.class, args);
	}

}