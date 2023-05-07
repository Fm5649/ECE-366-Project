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
    private String idToken;
    public String getIdToken() {
        return idToken;
    }
    public void setIdToken(String s) {idToken = s;}

    //Id of entry get and set
    public long getId() {
        return userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    //Player rank get and set
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    //Player username get and set
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //Player wins get and set
    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    //Player losses get and set
    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    //Player total games get and set
    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    //Player ELO get and set
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
