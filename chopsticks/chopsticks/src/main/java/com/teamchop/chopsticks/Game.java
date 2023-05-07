package com.teamchop.chopsticks;

import com.teamchop.chopsticks.util.DataTransferObject;

public class Game implements DataTransferObject
{

    private long gameId;
    private long p1Id;
    private long p2Id;
    private long winner;

    private String idToken;

    private String p1Name;

    private String p2Name;

    public String getIdToken() {
        return idToken;
    }
    public void setIdToken(String s) {idToken = s;}

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
    
    //Player one name get and set
    public String getPlayerOneName()
    {return p1Name;
    }
    public void setPlayerOneName(String p1Name)
    {
        this.p1Name = p1Name;
    }

    //Player two name get and set
    public String getPlayerTwoName()
    {return p2Name;
    }
    public void setPlayerTwoName(String p2Name)
    {
        this.p2Name = p2Name;
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
