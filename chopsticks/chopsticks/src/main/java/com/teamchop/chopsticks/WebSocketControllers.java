package com.teamchop.chopsticks;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class WebSocketControllers {
    @MessageMapping("/round")
    @SendTo("/websocket/insert")
    public GameRound insertGameRound(@RequestBody GameRound message) {
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
                game = gDAO.findById(g.getGameId());
                System.out.println(game);
                game.setWinner(a == 1 ? game.getPlayerOneId() : game.getPlayerTwoId());
                System.out.println("Winner: "+ game.getWinner());
                gDAO.updateWinner(game.getGameId(),game.getWinner());
            }
            System.out.println(g);

        }
        catch(SQLException e) {
            e.printStackTrace();

        }
        return g;
    }

}
