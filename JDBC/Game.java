
package com.chopsticks.lil.jdbc;

import com.chopsticks.lil.jdbc.util.DataTransferObject;
  
public class Game implements DataTransferObject
{

  private long gameId;
  private long p1_Id;
  private long p2_Id;
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
    return p1_Id;
  }
  public void setPlayerOneId(long p1_Id)
  {
    this.p1_Id = p1_Id;
  }
  
  //Player 2 Id get and set
  public long getPlayerTwoId() 
  {
    return p2_Id;
  }
  public void setPlayerTwoId(long p2_Id)
  {
    this.p2_Id = p2_Id;
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
                ", p1_Id='" + p1_Id + '\'' +
                ", p2_Id='" + p2_Id + '\'' +
                ", winner='" + winner + '\'' +
                '}';
  }
}

