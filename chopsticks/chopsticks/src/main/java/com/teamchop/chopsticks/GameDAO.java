package com.teamchop.chopsticks;

import com.teamchop.chopsticks.util.DataAccessObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAO extends DataAccessObject{

    public GameDAO(Connection connection) {
        super(connection);
    }
    private static final String GET_ONE_BY_ID = "select game.*, player.player_name, p2.player_name as player_name_2 from game "
    + "inner join player on player.player_id  = game.p1_id  left join player as p2 on  p2.player_id  = game.p2_id "+
            "where game.game_id = ?";

    private static final String INSERT_GAME = "INSERT INTO game (p1_id, p2_id) " +
            "VALUES (?, ?) RETURNING *";

    private static final String UPDATE_WINNER = "UPDATE game SET winner_id = ? " +
            "WHERE game_id = ?";

    private static final String GET_EVERY_AVAILABLE_GAME = "SELECT game.*, player.player_name " +
            "FROM game inner join player on game.p1_id = player.player_id " +
            "WHERE p1_id <> ? and p2_id is null and winner_id is null";

    private static final String GET_EVERY_ONGOING_AVAILABLE_GAME = "SELECT game.*, player.player_name, p2.player_name as player_name_2 " +
            "FROM game inner join player on game.p1_id = player.player_id " +
            "left join player as p2 on game.p2_id = p2.player_id "+
            "WHERE p1_id = ? or p2_id = ? and winner_id is null";
    private static final String GET_EVERY_FINISHED_GAME = "SELECT game.*, player.player_name, p2.player_name as player_name_2 " +
            "FROM game inner join player on game.p1_id = player.player_id " +
            "inner join player as p2 on game.p2_id = p2.player_id "+
            "WHERE p1_id = ? or p2_id = ? and winner_id is not null";

    private static final String UPDATE_OPPONENT = "UPDATE game SET p2_id = ? " +
            "WHERE game_id = ? and p2_id is null and p1_id <> ? RETURNING *";

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
                game.setPlayerOneName(rs.getString("player_name"));
                game.setPlayerTwoName(rs.getString("player_name_2"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return game;
    }

    public List<Game> findByPlayerId(long id) {

        List<Game> games = new ArrayList<>();
        System.out.println(GET_EVERY_AVAILABLE_GAME);
        try(PreparedStatement statement = this.connection.prepareStatement(GET_EVERY_AVAILABLE_GAME);) {
            statement.setLong(1, id);
            statement.setLong(2, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Game game = new Game();
                game.setGameId(rs.getLong("game_id"));
                game.setWinner(rs.getInt("winner_id"));
                game.setPlayerOneId(rs.getInt("p1_id"));
                game.setPlayerTwoId(rs.getInt("p2_id"));
                games.add(game);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return games;
    }

    public Game insertGame(long p1Id,long p2Id) {
        Game game = new Game();
        System.out.println(INSERT_GAME);
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT_GAME);) {
            statement.setLong(1, p1Id);
            statement.setNull(2, Types.NUMERIC);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while(rs.next()) {
                game.setGameId(rs.getLong(1));
                game.setPlayerOneId(p1Id);
                game.setPlayerTwoId(0);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return game;
    }
    public List<Game> getAvailableGames(long p1Id) {
        List<Game> games = new ArrayList<>();
        System.out.println(GET_EVERY_AVAILABLE_GAME);
        try(PreparedStatement statement = this.connection.prepareStatement(GET_EVERY_AVAILABLE_GAME);) {
            statement.setLong(1, p1Id);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while(rs.next()) {
                Game game = new Game();
                game.setGameId(rs.getLong("game_id"));
                game.setPlayerOneId(rs.getLong("p1_id"));
                game.setPlayerOneName(rs.getString("player_name"));
                games.add(game);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return games;
    }

    public List<Game> getFinishedGames(long p1Id) {
        List<Game> games = new ArrayList<>();
        System.out.println(GET_EVERY_FINISHED_GAME);
        try(PreparedStatement statement = this.connection.prepareStatement(GET_EVERY_FINISHED_GAME);) {
            statement.setLong(1, p1Id);
            statement.setLong(2, p1Id);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while(rs.next()) {
                Game game = new Game();
                game.setGameId(rs.getLong("game_id"));
                game.setPlayerOneId(rs.getLong("p1_id"));
                game.setPlayerTwoId(rs.getLong("p2_id"));
                game.setPlayerOneName(rs.getString("player_name"));
                game.setPlayerTwoName(rs.getString("player_name_2"));
                game.setWinner(rs.getLong("winner_id"));
                games.add(game);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return games;
    }
    public List<Game> getOngoingGames(long p1Id) {
        List<Game> games = new ArrayList<>();
        System.out.println(GET_EVERY_ONGOING_AVAILABLE_GAME);
        try(PreparedStatement statement = this.connection.prepareStatement(GET_EVERY_ONGOING_AVAILABLE_GAME);) {
            statement.setLong(1, p1Id);
            statement.setLong(2, p1Id);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while(rs.next()) {
                Game game = new Game();
                game.setGameId(rs.getLong("game_id"));
                game.setPlayerOneId(rs.getLong("p1_id"));
                game.setPlayerTwoId(rs.getLong("p2_id"));
                game.setPlayerOneName(rs.getString("player_name"));
                game.setPlayerTwoName(rs.getString("player_name_2"));
                game.setWinner(rs.getLong("winner_id"));
                games.add(game);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return games;
    }

    public void updateWinner(long gameId, long winnerId) {
        System.out.println(UPDATE_WINNER);
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE_WINNER);) {
            statement.setLong(1, winnerId);
            statement.setLong(2, gameId);
            statement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Game updateOpponent(long gameId, long opponentId) {
        System.out.println(UPDATE_OPPONENT);
        Game game = new Game();
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE_OPPONENT);) {
            statement.setLong(1, opponentId);
            statement.setLong(2, gameId);
            statement.setLong(3, opponentId);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while(rs.next()) {
                game.setGameId(rs.getLong("game_id"));
                game.setPlayerOneId(rs.getLong("p1_id"));
                game.setPlayerTwoId(rs.getLong("p2_id"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return game;
    }
}
