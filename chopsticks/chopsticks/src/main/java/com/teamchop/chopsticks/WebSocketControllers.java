package com.teamchop.chopsticks;
import com.teamchop.chopsticks.message.JoinMessage;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Header;

import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class WebSocketControllers {
    @MessageMapping("/insert")
    @SendTo("/topics/insert")
    public GameRound insertGameRound(@Payload GameRound message) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        GameRound g=null;
        try {
            Connection connection = dcm.getConnection();
            GameRoundDAO gameDAO = new GameRoundDAO(connection);
            if (GameLogic.isValidMove(message)) {
                g = gameDAO.insertGameRound(message.getGameId(),
                        message.getRoundNumber(),
                        message.getPlayerTurn(),
                        message.getPlayerChoice(),
                        message.getPlayerHandUsed(),
                        message.getTarget(),
                        message.getAmount(),
                        message.getP1Hand1(),
                        message.getP1Hand2(),
                        message.getP2Hand1(),
                        message.getP2Hand2());
            }
            int a = GameLogic.winner(message);
            if (a > 0) {
                Game game = null;
                GameDAO gDAO = new GameDAO(connection);
                PlayerDAO pDao = new PlayerDAO(connection);
                game = gDAO.findById(g.getGameId());
                System.out.println(game);
                game.setWinner(a == 1 ? game.getPlayerOneId() : game.getPlayerTwoId());
                System.out.println("Winner: "+ game.getWinner());
                gDAO.updateWinner(game.getGameId(),game.getWinner());
                Player p = pDao.findById(game.getWinner());
                Player l = pDao.findById(a == 1 ? game.getPlayerTwoId() : game.getPlayerOneId());
                p.setTotalGames(p.getTotalGames()+1);
                p.setTotalWins(p.getTotalWins()+1);
                l.setTotalGames(l.getTotalGames()+1);
                l.setTotalLosses(l.getTotalLosses()+1);
                long[] ans = GameLogic.getElo(p.getPlayerElo(),l.getPlayerElo());
                p.setPlayerElo((int)ans[0]);
                l.setPlayerElo((int)ans[1]);
                pDao.updateStats(p);
                pDao.updateStats(l);
            }
            System.out.println(g);

        }
        catch(SQLException e) {
            e.printStackTrace();

        }
        return g;
    }

    @MessageMapping("/forfeit")
    @SendTo("/topics/forfeit")
    public void forfeit(@Payload JoinMessage message) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Game g = null;
        try {
            Connection connection = dcm.getConnection();
            GameDAO gameDAO = new GameDAO(connection);
            g = gameDAO.updateOpponent(message.getGameId(), message.getUserId());
            System.out.println(g);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    @MessageMapping("/join")
    @SendTo("/topics/join")
    public Game joinGame(@Payload JoinMessage message) {
        System.out.println("received");
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "chopsticks", "postgres", "password");
        Game g = null;
        try {
            Connection connection = dcm.getConnection();
            GameDAO gameDAO = new GameDAO(connection);
            g = gameDAO.updateOpponent(message.getGameId(), message.getUserId());
            System.out.println(g);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return g;
    }


}
