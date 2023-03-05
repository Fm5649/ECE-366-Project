package com.chopsticks.lil.jdbc;

import com.chopsticks.lil.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GameDAO extends DataAccessObject{

    public GameDAO(Connection connection) {
        super(connection);
    }
    private static final String GET_ONE_BY_ID = "SELECT game_id, p1_id, p2_id, winner_id, " +
            "FROM game WHERE game_id=?";

    private static final String INSERT_GAME = "INSERT INTO game (p1_id, p2_id) " +
            "VALUES (?, ?)";

    public Game findById(long id) {
        Game game = new Game();
        System.out.println(GET_ONE_BY_ID);
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE_BY_ID);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                game.setGameId(rs.getLong("game_id"));
                game.setWinner(rs.getInt("winner_id"));
                game.setPlayerOneId(rs.getInt("p1_id"));
                game.setPlayerTwoId(rs.getInt("p2_id"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return game;
    }

    public Game insertGame(long p1Id, long p2Id) {
        Game game = new Game();
        System.out.println(INSERT_GAME);
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT_GAME);) {
            statement.setLong(1, p1Id);
            statement.setLong(2, p2Id);
            statement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return game;
    }
}
