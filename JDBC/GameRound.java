
package com.chopsticks.lil.jdbc;

import com.chopsticks.lil.jdbc.util.DataTransferObject;
  
public class GameRound implements DataTransferObject
{
  private long gameId;
  private String playerTurn;
  private String playerChoice;
  private String target;
  private int p1_LeftHand;
  private int p1_RightHand;
  private int p2_LeftHand;
  private int p2_RightHand;
  
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
    return p1_LeftHand;
  }
  public void setPlayerOneLeftHand(int p1_LeftHand)
  {
    this.p1_LeftHand = p1_LeftHand;
  }
  
  //Player 1 right hand get and set
  public int getPlayerOneRightHand() 
  {
    return p1_RightHand;
  }
  public void setPlayerOneRightHand(int p1_RightHand)
  {
    this.p1_RightHand = p1_RightHand;
  }
  
  //Player 2 left hand get and set
  public int getPlayerTwoLeftHand() 
  {
    return p2_LeftHand;
  }
  public void setPlayerTwoLeftHand(int p2_LeftHand)
  {
    this.p2_LeftHand = p2_LeftHand;
  }
  
  //Player 2 right hand get and set
  public int getPlayerTwoRightHand() 
  {
    return p2_RightHand;
  }
  public void setPlayerTwoRightHand(int p2_RightHand)
  {
    this.p2_RightHand = p2_RightHand;
  }
  
  @Override
  public String toString() 
  {
      return "GameRound{" +
                "gameId=" + gameId +
                ", playerTurn='" + playerTurn + '\'' +
                ", playerChoice='" + playerChoice + '\'' +
                ", target='" + target + '\'' +
                ", p1_LeftHand='" + p1_LeftHand + '\'' +
                ", p1_RightHand='" + p1_RightHand + '\'' +
                ", p2_LeftHand='" + p2_LeftHand + '\'' +
                ", p2_RightHand='" + p2_RightHand + '\'' +
                '}';
  }
}

