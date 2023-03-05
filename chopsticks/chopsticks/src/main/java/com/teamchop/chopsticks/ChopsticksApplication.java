package com.teamchop.chopsticks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
@RestController
public class ChopsticksApplication {
	@PostMapping("/getPlayerById")
	public Player create(@RequestBody String message) {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"chopsticks", "postgres", "password");
		Player player = new Player();
		try {
			Connection connection = dcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);

			player = playerDAO.findById(Integer.parseInt(message));
			System.out.println(player.getPlayerId() + " " + player.getPlayerName() + " " + player.getPassword());
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return player;
	}
	public static void main(String[] args) {
		System.out.println("Hello.");
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
				"chopsticks", "postgres", "password");

		try {
			Connection connection = dcm.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM player");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
			}
			PlayerDAO playerDAO = new PlayerDAO(connection);
			Player player = playerDAO.findById(1);
			System.out.println(player);
			player = playerDAO.findByUserName("Tszhim");
			System.out.println(player);

			GameDAO gameDAO = new GameDAO(connection);
			gameDAO.insertGame(1, 2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		SpringApplication.run(ChopsticksApplication.class, args);
	}

}
