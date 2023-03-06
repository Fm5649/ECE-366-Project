package com.teamchop.chopsticks;

import com.teamchop.chopsticks.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAO extends DataAccessObject {

    private static final String GET_ONE_BY_ID = "SELECT player_id a, player_name b, password c, " +
            "total_games d FROM player WHERE player_id=?";

    private static final String GET_ONE_BY_USER_NAME = "SELECT player_id, player_name, password, " +
            "total_games FROM player WHERE player_name=?";

    private static final String UPDATE_STATS = "UPDATE player SET (total_games, total_wins, total_losses, elo)" +
            " = (?, ?, ?, ?) WHERE player_id=?";

    public PlayerDAO(Connection connection) {
        super(connection);
    }

    public Player findById(long id) {
        Player user = new Player();
        System.out.println(GET_ONE_BY_ID);
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE_BY_ID);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                user.setPlayerId(rs.getLong("a"));
                user.setPlayerName(rs.getString("b"));
                user.setPassword(rs.getString("c"));
                user.setTotalGames(rs.getInt("d"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return user;
    }

    public Player findByUserName(String name) {
        Player user = new Player();
        System.out.println(GET_ONE_BY_USER_NAME);
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE_BY_USER_NAME);) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                user.setPlayerId(rs.getLong("player_id"));
                user.setPlayerName(rs.getString("player_name"));
                user.setPassword(rs.getString("password"));
                user.setTotalGames(rs.getInt("total_games"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return user;
    }

    public void updateStats(Player p) {
        System.out.println(UPDATE_STATS);
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE_STATS);) {
            statement.setInt(1, p.getTotalGames());
            statement.setInt(2, p.getTotalWins());
            statement.setInt(3, p.getTotalLosses());
            statement.setInt(4, p.getPlayerElo());
            ResultSet rs = statement.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
