package com.teamchop.chopsticks;

import com.teamchop.chopsticks.util.DataTransferObject;

public class Player implements DataTransferObject {
    private long playerId;
    private String playerName;
    private String password;
    private int totalGames;
    private int totalWins;
    private int totalLosses;
    private int playerElo;

    public long getId() {
        return playerId;
    }

    public long getPlayerId() {
        return playerId;
    }
    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getTotalLosses() {
        return totalLosses;
    }

    public void setTotalLosses(int totalLosses) {
        this.totalLosses = totalLosses;
    }

    public int getPlayerElo() {
        return playerElo;
    }

    public void setPlayerElo(int playerElo) {
        this.playerElo = playerElo;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", password='" + password + '\'' +
                ", totalGames=" + totalGames +
                ", totalWins=" + totalWins +
                ", totalLosses=" + totalLosses +
                ", playerElo=" + playerElo +
                '}';
    }
}
