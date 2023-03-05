package com.chopsticks.lil.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
    public static void main(String[] args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
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
    }
}