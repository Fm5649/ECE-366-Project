
package com.chopsticks.lil.jdbc;

import com.chopsticks.lil.jdbc.util.DataTransferObject;
  
public class GameRound implements DataTransferObject
{
  private long gameId;
  private String playerTurn;
  private String playerChoice;
  private String target;
  private int p1LeftHand;
  private int p1RightHand;
  private int p2LeftHand;
  private int p2RightHand;
  
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
  
  //Player Turn get and set
  public String getPlayerTurn() 
  {
    return playerTurn;
  }
  public void setPlayerTurn(String playerTurn)
  {
    this.playerTurn = playerTurn;
  }
  
  //Player Choice get and set
  public String getPlayerChoice() 
  {
    return playerChoice;
  }
  public void setPlayerChoice(String playerChoice)
  {
    this.playerChoice = playerChoice;
  }
  
  //target get and set
  public String getTarget() 
  {
    return target;
  }
  public void setTarget(String target)
  {
    this.target = target;
  }
  
  //Player 1 left hand get and set
  public int getPlayerOneLeftHand() 
  {
    return p1LeftHand;
  }
  public void setPlayerOneLeftHand(int p1LeftHand)
  {
    this.p1LeftHand = p1LeftHand;
  }
  
  //Player 1 right hand get and set
  public int getPlayerOneRightHand() 
  {
    return p1RightHand;
  }
  public void setPlayerOneRightHand(int p1RightHand)
  {
    this.p1RightHand = p1RightHand;
  }
  
  //Player 2 left hand get and set
  public int getPlayerTwoLeftHand() 
  {
    return p2LeftHand;
  }
  public void setPlayerTwoLeftHand(int p2LeftHand)
  {
    this.p2LeftHand = p2LeftHand;
  }
  
  //Player 2 right hand get and set
  public int getPlayerTwoRightHand() 
  {
    return p2RightHand;
  }
  public void setPlayerTwoRightHand(int p2RightHand)
  {
    this.p2RightHand = p2RightHand;
  }
  
  @Override
  public String toString() 
  {
      return "GameRound{" +
                "gameId=" + gameId +
                ", playerTurn='" + playerTurn + '\'' +
                ", playerChoice='" + playerChoice + '\'' +
                ", target='" + target + '\'' +
                ", p1LeftHand='" + p1LeftHand + '\'' +
                ", p1RightHand='" + p1RightHand + '\'' +
                ", p2LeftHand='" + p2LeftHand + '\'' +
                ", p2RightHand='" + p2RightHand + '\'' +
                '}';
  }
}

