package com.teamchop.chopsticks.business;

import com.teamchop.chopsticks.DatabaseConnectionManager;
import com.teamchop.chopsticks.Player;
import com.teamchop.chopsticks.PlayerDAO;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    public List<Player> getPlayers() {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("db", "chopsticks", "postgres", "password");
        List<Player> playerList = new ArrayList<>();

        try {
            Connection connection = dcm.getConnection();
            PlayerDAO playerDAO = new PlayerDAO(connection);

            playerList = playerDAO.getPlayers();
            System.out.println(playerList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playerList;
    }
}
