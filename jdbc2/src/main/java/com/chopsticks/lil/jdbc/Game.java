package com.chopsticks.lil.jdbc;

import com.chopsticks.lil.jdbc.util.DataTransferObject;

public class Game implements DataTransferObject
{

    private long gameId;
    private long p1Id;
    private long p2Id;
    private long winner;

    //GameId get and set
    public long getId()
    {
        return gameId;
    }
    public long getGameId()
    {
        return gameId;
    }
    public void setGameId(long gameId)
    {
        this.gameId = gameId;
    }

    //Player 1 Id get and set
    public long getPlayerOneId()
    {
        return p1Id;
    }
    public void setPlayerOneId(long p1Id)
    {
        this.p1Id = p1Id;
    }

    //Player 2 Id get and set
    public long getPlayerTwoId()
    {
        return p2Id;
    }
    public void setPlayerTwoId(long p2Id)
    {
        this.p2Id = p2Id;
    }

    //Winner get and set
    public long getWinner()
    {
        return winner;
    }
    public void setWinner(long winner)
    {
        this.winner = winner;
    }

    @Override
    public String toString()
    {
        return "Game{" +
                "gameId=" + gameId +
                ", p1Id='" + p1Id + '\'' +
                ", p2Id='" + p2Id + '\'' +
                ", winner='" + winner + '\'' +
                '}';
    }
}