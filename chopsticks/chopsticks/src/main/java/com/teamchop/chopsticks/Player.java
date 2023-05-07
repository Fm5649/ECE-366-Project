package com.teamchop.chopsticks;

import com.teamchop.chopsticks.util.DataTransferObject;

public class Player implements DataTransferObject {
    private long playerId;
    private String playerEmail;
    private String playerName;
    private String password;
    private int totalGames;
    private int totalWins;
    private int totalLosses;
    private int playerElo;
    private int achievementFirstWin;
    private int achievementFirstGame;
    private String firebaseId;
    private String idToken;
    public String getIdToken() {
        return idToken;
    }
    public void setIdToken(String s) {idToken = s;}

    //Player id get and set
    public long getId() {
        return playerId;
    }

    public String getFirebaseId() {return firebaseId;}
    public void setFirebaseId(String id) {firebaseId = id;}

    public long getPlayerId() {
        return playerId;
    }
    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }
    
    //Player email get and set
    public String getPlayerEmail() {
        return playerEmail;
    }

    public void setPlayerEmail(String playerEmail) {
        this.playerEmail = playerEmail;
    }

    //Username get and set
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    //Password get and set
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Total games get and set
    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    //Total wins get and set
    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    //Total losses get and set
    public int getTotalLosses() {
        return totalLosses;
    }

    public void setTotalLosses(int totalLosses) {
        this.totalLosses = totalLosses;
    }

    //ELO get and set
    public int getPlayerElo() {
        return playerElo;
    }

    public void setPlayerElo(int playerElo) {
        this.playerElo = playerElo;
    }
    
    //Getting achievement for first win
    public int getAchievementFirstWin() {
        return achievementFirstWin;
    }

    public void setAchievementFirstWin(int achievementFirstWin) {
        this.achievementFirstWin = achievementFirstWin;
    }
    
    //Getting achievement for first game
    public int getAchievementFirstGame() {
        return achievementFirstGame;
    }

    public void setAchievementFirstGame(int achievementFirstGame) {
        this.achievementFirstGame = achievementFirstGame;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerEmail='" + playerEmail + '\'' +
                ", playerName='" + playerName + '\'' +
                ", password='" + password + '\'' +
                ", totalGames=" + totalGames +
                ", totalWins=" + totalWins +
                ", totalLosses=" + totalLosses +
                ", playerElo=" + playerElo +
                ", achievementFirstWin=" + achievementFirstWin +
                ", achievementFirstGame=" + achievementFirstGame +
                '}';
    }
}
