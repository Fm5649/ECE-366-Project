package com.teamchop.chopsticks;

import com.teamchop.chopsticks.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO extends DataAccessObject {

    private static final String GET_PLAYERS = "SELECT * FROM player";

    private static final String GET_ONE_BY_ID = "SELECT * FROM player WHERE player_id=?";

    private static final String GET_ONE_BY_USER_NAME = "SELECT * FROM player WHERE player_name=?";
 
    private static final String UPDATE_STATS = "UPDATE player SET (total_games, total_wins, total_losses, player_elo)" +
            " = (?, ?, ?, ?) WHERE player_id=? RETURNING *";

    private static final String INSERT_PLAYER = "INSERT INTO player (player_name, password) VALUES (?,?)" +
            "RETURNING *";
    
    private static final String DELETE_BY_ID = "DELETE FROM player WHERE player_id=? RETURNING *";

    public PlayerDAO(Connection connection) {
        super(connection);
    }

    public List<Player> getPlayers() {
        List<Player> playerList = new ArrayList<>();
        System.out.println(GET_PLAYERS);
        try(PreparedStatement statement = this.connection.prepareStatement(GET_PLAYERS);) {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Player player = new Player();
                player.setPlayerId(rs.getLong("player_id"));
                player.setPlayerName(rs.getString("player_name"));
                player.setPassword(rs.getString("password"));
                player.setTotalGames(rs.getInt("total_games"));
                player.setTotalWins(rs.getInt("total_wins"));
                player.setTotalLosses(rs.getInt("total_losses"));
                player.setPlayerElo(rs.getInt("player_elo"));
                player.setAchievementFirstWin(rs.getInt("achievement_first_win"));
                player.setAchievementFirstGame(rs.getInt("achievement_first_game"));
                playerList.add(player);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }
        return playerList;
    }

    public Player findById(long id) {
        Player user = new Player();
        System.out.println(GET_ONE_BY_ID);
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE_BY_ID);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                user.setPlayerId(rs.getLong("player_id"));
                user.setPlayerName(rs.getString("player_name"));
                user.setPassword(rs.getString("password"));
                user.setTotalGames(rs.getInt("total_games"));
                user.setTotalWins(rs.getInt("total_wins"));
                user.setTotalLosses(rs.getInt("total_losses"));
                user.setPlayerElo(rs.getInt("player_elo"));
                user.setAchievementFirstWin(rs.getInt("achievement_first_win"));
                user.setAchievementFirstGame(rs.getInt("achievement_first_game"));
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
                user.setTotalWins(rs.getInt("total_wins"));
                user.setTotalLosses(rs.getInt("total_losses"));
                user.setPlayerElo(rs.getInt("player_elo"));
                user.setAchievementFirstWin(rs.getInt("achievement_first_win"));
                user.setAchievementFirstGame(rs.getInt("achievement_first_game"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return user;
    }

    public Player insertUserName(String userName, String password) {
        Player user = new Player();
        System.out.println(INSERT_PLAYER);
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT_PLAYER);) {
            statement.setString(1, userName);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                user.setPlayerId(rs.getLong("player_id"));
                user.setPlayerName(rs.getString("player_name"));
                user.setPassword(rs.getString("password"));
                user.setTotalGames(rs.getInt("total_games"));
                user.setTotalWins(rs.getInt("total_wins"));
                user.setTotalLosses(rs.getInt("total_losses"));
                user.setPlayerElo(rs.getInt("player_elo"));
                user.setAchievementFirstWin(rs.getInt("achievement_first_win"));
                user.setAchievementFirstGame(rs.getInt("achievement_first_game"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return user;
    }

    public Player updateStats(Player p) {
        System.out.println(UPDATE_STATS);
        try (PreparedStatement statement = this.connection.prepareStatement(UPDATE_STATS);) {
            statement.setInt(1, p.getTotalGames());
            statement.setInt(2, p.getTotalWins());
            statement.setInt(3, p.getTotalLosses());
            statement.setInt(4, p.getPlayerElo());
            statement.setLong(5, p.getPlayerId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                p.setPlayerId(rs.getLong("player_id"));
                p.setPlayerName(rs.getString("player_name"));
                p.setPassword(rs.getString("password"));
                p.setTotalGames(rs.getInt("total_games"));
                p.setTotalWins(rs.getInt("total_wins"));
                p.setTotalLosses(rs.getInt("total_losses"));
                p.setPlayerElo(rs.getInt("player_elo"));
                p.setAchievementFirstWin(rs.getInt("achievement_first_win"));
                p.setAchievementFirstGame(rs.getInt("achievement_first_game"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return p;
    }
    
    public Player deleteById(long id) {
        Player user = new Player();
        System.out.println(DELETE_BY_ID);
        try(PreparedStatement statement = this.connection.prepareStatement(DELETE_BY_ID);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                user.setPlayerId(rs.getLong("player_id"));
                user.setPlayerName(rs.getString("player_name"));
                user.setPassword(rs.getString("password"));
                user.setTotalGames(rs.getInt("total_games"));
                user.setTotalWins(rs.getInt("total_wins"));
                user.setTotalLosses(rs.getInt("total_losses"));
                user.setPlayerElo(rs.getInt("player_elo"));
                user.setAchievementFirstWin(rs.getInt("achievement_first_win"));
                user.setAchievementFirstGame(rs.getInt("achievement_first_game"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return user;
    }
}
