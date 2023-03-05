/*
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.chopsticks.lil.jdbc;

@SpringBootApplication
@RestController
public class Chopstick {

	@PostMapping("/getPlayerById")
	public Player getPlayer(@RequestBody String message) {
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
		}
		return player;
	}

    @PostMapping("/getPlayerByName")
	public Player create(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		Player player = new Player();
		try {
			Connection connection = dcm.getConnection();
			PlayerDAO PlayerDAO = new PlayerDAO(connection);

			player = PlayerDAO.findById(message);
			System.out.println(player);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return player;
	}

    @PostMapping("/getGameById")
	public void getGameById(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		try {
			Connection connection = dcm.getConnection();
			GameDAO gameDAO = new GameDAO(connection);

			Game g = gameDAO.findById(Integer.parseInt(message));
            System.out.println(g);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

    @PostMapping(value = "/insertGame")
	public void insertGame(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		try {
			Connection connection = dcm.getConnection();
			GameDAO gameDAO = new GameDAO(connection);

			Game g = gameDAO.findById(Integer.parseInt(message.p1), Integer.parseInt(message.p2));
            System.out.println(g);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

    @PostMapping(value = "/getGameRoundById")
	public void getGameRoundById(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		try {
			Connection connection = dcm.getConnection();
			GameRoundDAO gameDAO = new GameRoundDAO(connection);

			GameRound g = gameDAO.findById(Integer.parseInt(message));
            System.out.println(g);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
    //long gameId, int roundNumber, String playerturn, String playerChoice, String target, int amount, int p1Hand1, int p1Hand2, int p2hand1, int p2Hand2
    @PostMapping(value = "/insertGameRound")
	public void getGameRoundById(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		try {
			Connection connection = dcm.getConnection();
			GameRoundDAO gameDAO = new GameRoundDAO(connection);

			GameRound g = gameDAO.findById(Integer.parseInt(message.gameId),
            Integer.parseInt(message.roundNumber),
            message.playerturn,
            message.playerChoice,
            message.target,
            Integer.parseInt(message.amount),
            Integer.parseInt(message.p1Hand1),
            Integer.parseInt(message.p1Hand2),
            Integer.parseInt(message.p2Hand1),
            Integer.parseInt(message.p2Hand2));
            System.out.println(g);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

    @PostMapping(value = "/getLeaderboardById")
	public void getGameRoundById(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		try {
			Connection connection = dcm.getConnection();
			LeaderboardDAO leaderDAO = new LeaderboardDAO(connection);

			Leaderboard l = leaderDAO.findById(Integer.parseInt(message));
            System.out.println(l);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
    @PostMapping(value = "/insertLeaderboard")
	public void getGameRoundById(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		try {
			Connection connection = dcm.getConnection();
			LeaderboardDAO leaderDAO = new LeaderboardDAO(connection);

			Leaderboard g = LeaderboardDAO.findById(Integer.parseInt(message.rank),
            message.username,
            Integer.parseInt(message.wins),
            Integer.parseInt(message.losses),
            Integer.parseInt(message.totalGames),
            Integer.parseInt(message.elo),
            Integer.parseInt(message.userId));
            System.out.println(g);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("Hello!");

		SpringApplication.run(chopsticksApplication.class, args);
	}

}
*/