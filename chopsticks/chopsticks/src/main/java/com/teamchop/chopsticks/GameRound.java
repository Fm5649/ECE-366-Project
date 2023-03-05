package com.teamchop.chopsticks;

import com.teamchop.chopsticks.util.DataTransferObject;

public class GameRound implements DataTransferObject {
    private long gameId;
    private int roundNumber;
    private String playerTurn;
    private String playerChoice;
    private String playerHandUsed;
    private String target;
    private int amount;
    private int p1Hand1;
    private int p1Hand2;
    private int p2Hand1;
    private int p2Hand2;

    public long getId()
    {
        return gameId;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public String getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(String playerTurn) {
        this.playerTurn = playerTurn;
    }

    public String getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(String playerChoice) {
        this.playerChoice = playerChoice;
    }

    public String getPlayerHandUsed() {
        return playerHandUsed;
    }

    public void setPlayerHandUsed(String playerHandUsed) {
        this.playerHandUsed = playerHandUsed;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getP1Hand1() {
        return p1Hand1;
    }

    public void setP1Hand1(int p1Hand1) {
        this.p1Hand1 = p1Hand1;
    }

    public int getP1Hand2() {
        return p1Hand2;
    }

    public void setP1Hand2(int p1Hand2) {
        this.p1Hand2 = p1Hand2;
    }

    public int getP2Hand1() {
        return p2Hand1;
    }

    public void setP2Hand1(int p2Hand1) {
        this.p2Hand1 = p2Hand1;
    }

    public int getP2Hand2() {
        return p2Hand2;
    }

    public void setP2Hand2(int p2Hand2) {
        this.p2Hand2 = p2Hand2;
    }

    @Override
    public String toString() {
        return "GameRound{" +
                "gameId=" + gameId +
                ", roundNumber=" + roundNumber +
                ", playerTurn='" + playerTurn + '\'' +
                ", playerChoice='" + playerChoice + '\'' +
                ", target='" + target + '\'' +
                ", amount=" + amount +
                ", p1Hand1=" + p1Hand1 +
                ", p1Hand2=" + p1Hand2 +
                ", p2Hand1=" + p2Hand1 +
                ", p2Hand2=" + p2Hand2 +
                '}';
    }
}