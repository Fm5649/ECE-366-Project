package com.teamchop.chopsticks;

import com.teamchop.chopsticks.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GameRoundDAO extends DataAccessObject{

    public GameRoundDAO(Connection connection) {
        super(connection);
    }

    private static final String UPDATE_HANDS = "UPDATE game_round SET (p1_hand1, p1_hand2, p2_hand1, p2_hand2) = (?, ?, ?, ?) WHERE game_id=? RETURNING *";
    private static final String GET_ONE_BY_ID = "SELECT game_id, round_number, " +
            "turn_player_name, player_choice, player_hand_used, player_target, " +
            "player_action_amount, p1_hand1, p1_hand2, " +
            "p2_hand1, p2_hand2 FROM game_round WHERE game_id=?";

    private static final String INSERT_GAMEROUND = "INSERT INTO game_round (game_id, " +
            "round_number, turn_player_name, player_choice, player_hand_used, player_target, " +
            "player_action_amount, p1_hand1, p1_hand2, p2_hand1, p2_hand2) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";


    public GameRound updateHands(GameRound g) {
        GameRound gameRound = new GameRound();
        System.out.println(UPDATE_HANDS);
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE_HANDS);) {
            statement.setInt(1, g.getP1Hand1());
            statement.setInt(2, g.getP1Hand2());
            statement.setInt(3, g.getP2Hand1());
            statement.setInt(4, g.getP2Hand2());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                gameRound.setGameId(rs.getLong("game_id"));
                gameRound.setRoundNumber(rs.getInt("round_number"));
                gameRound.setPlayerTurn(rs.getString("turn_player_name"));
                gameRound.setPlayerChoice(rs.getString("player_choice"));
                gameRound.setTarget(rs.getString("player_target"));
                gameRound.setAmount(rs.getInt("player_action_amount"));
                gameRound.setP1Hand1(rs.getInt("p1_hand1"));
                gameRound.setP1Hand2(rs.getInt("p1_hand2"));
                gameRound.setP2Hand1(rs.getInt("p2_hand1"));
                gameRound.setP2Hand2(rs.getInt("p2_hand2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return gameRound;
    }
    public GameRound findById(long id) {
        GameRound gameRound = new GameRound();
        System.out.println(GET_ONE_BY_ID);
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE_BY_ID);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                gameRound.setGameId(rs.getLong("game_id"));
                gameRound.setRoundNumber(rs.getInt("round_number"));
                gameRound.setPlayerTurn(rs.getString("turn_player_name"));
                gameRound.setPlayerChoice(rs.getString("player_choice"));
                gameRound.setTarget(rs.getString("player_target"));
                gameRound.setAmount(rs.getInt("player_action_amount"));
                gameRound.setP1Hand1(rs.getInt("p1_hand1"));
                gameRound.setP1Hand2(rs.getInt("p1_hand2"));
                gameRound.setP2Hand1(rs.getInt("p2_hand1"));
                gameRound.setP2Hand2(rs.getInt("p2_hand2"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return gameRound;
    }

    public GameRound insertGameRound(long gameId, int roundNumber, String playerTurn, String playerChoice, String playerHandUsed, String target, int amount, int p1Hand1, int p1Hand2, int p2Hand1, int p2Hand2) {
        GameRound gameRound = new GameRound();
        System.out.println(INSERT_GAMEROUND);
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT_GAMEROUND);) {
            statement.setLong(1, gameId);
            statement.setInt(2, roundNumber);
            statement.setString(3, playerTurn);
            statement.setString(4, playerChoice);
            statement.setString(5, playerHandUsed);
            statement.setString(6, target);
            statement.setInt(7, amount);
            statement.setInt(8, p1Hand1);
            statement.setInt(9, p1Hand2);
            statement.setInt(10, p2Hand1);
            statement.setInt(11, p2Hand2);
            statement.execute();
            gameRound.setGameId(gameId);
            gameRound.setRoundNumber(roundNumber);
            gameRound.setAmount(amount);
            gameRound.setTarget(target);
            gameRound.setP1Hand1(p1Hand1);
            gameRound.setP1Hand2(p1Hand2);
            gameRound.setP2Hand1(p2Hand1);
            gameRound.setP2Hand2(p2Hand2);
            gameRound.setPlayerChoice(playerChoice);
            gameRound.setPlayerHandUsed(playerHandUsed);
            gameRound.setPlayerTurn(playerTurn);
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return gameRound;
    }
}
