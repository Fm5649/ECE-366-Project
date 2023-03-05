package com.chopsticks.lil.jdbc;

import com.chopsticks.lil.jdbc.Game;
import com.chopsticks.lil.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LeaderboardDAO extends DataAccessObject{

    public LeaderboardDAO(Connection connection) {
        super(connection);
    }
    private static final String GET_ONE_BY_ID = "SELECT leaderboard_rank, " +
            "leaderboard_username, leaderboard_wins, leaderboard_losses, " +
            "leaderboard_total_games, leaderboard_elo, leaderboard_player_id," +
            "FROM leaderboard WHERE leaderboard_player_id=?";

    private static final String INSERT_LEADERBOARD = "INSERT INTO " +
            "leaderboard (leaderboard_rank, leaderboard_username, " +
            "leaderboard_wins, leaderboard_losses, leaderboard_total_games, " +
            "leaderboard_elo, leaderboard_player_id) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

    public Leaderboard findById(long id) {
        Leaderboard leaderboard = new Leaderboard();
        System.out.println(GET_ONE_BY_ID);
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE_BY_ID);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                leaderboard.setRank(rs.getInt("leaderboard_rank"));
                leaderboard.setUsername(rs.getString("leaderboard_username"));
                leaderboard.setWins(rs.getInt("leaderboard_wins"));
                leaderboard.setLosses(rs.getInt("leaderboard_losses"));
                leaderboard.setTotalGames(rs.getInt("leaderboard_total_games"));
                leaderboard.setElo(rs.getInt("leaderboard_elo"));
                leaderboard.setUserId(rs.getInt("leaderboard_losses"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return leaderboard;
    }

    public Leaderboard insertLeaderboard(int rank, String username, int wins, int losses, int totalGames, int elo, long userId) {
        Leaderboard leaderboard = new Leaderboard();
        System.out.println(INSERT_LEADERBOARD);
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT_LEADERBOARD);) {
            statement.setInt(1, rank);
            statement.setString(2, username);
            statement.setInt(3, wins);
            statement.setInt(4, losses);
            statement.setInt(5, totalGames);
            statement.setInt(6, elo);
            statement.setLong(7, userId);
            statement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return leaderboard;
    }
}
