package com.teamchop.chopsticks;

import com.teamchop.chopsticks.util.DataTransferObject;

public class Leaderboard implements DataTransferObject {
    private long userId;
    private int rank;
    private String username;
    private int wins;
    private int losses;
    private int totalGames;
    private int elo;

    public long getId() {
        return userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    @Override
    public String toString() {
        return "Leaderboard{" +
                "userId=" + userId +
                ", rank=" + rank +
                ", username='" + username + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                ", totalGames=" + totalGames +
                ", elo=" + elo +
                '}';
    }
}