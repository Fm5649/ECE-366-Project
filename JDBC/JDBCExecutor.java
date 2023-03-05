


package com.chopsticks.lil.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor 
{
  public static void main(String... args) 
  {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                "chopsticks", "postgres", "password");

        try {
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM player");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }
          //Create first player
          PlayerDAO playerDAO = new PlayerDAO(connection);
          
          Player playerOne = 
          System.out.println(playerOne.getPlayerId() + " " + playerOne.getUserName() + " " + playerOne.getPassWord());
          
          //Create second player
          PlayerDAO playerDAO = new PlayerDAO(connection);
          
          Player playerTwo = 
          System.out.println(playerTwo.getPlayerId() + " " + playerTwo.getUserName() + " " + playerTwo.getPassWord());
          
          //Create Game
          GameDAO gameDAO = new GameDAO(connection);
          
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
  
