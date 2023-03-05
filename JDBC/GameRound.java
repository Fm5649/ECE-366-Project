
package com.chopsticks.lil.jdbc;

import com.chopsticks.lil.jdbc.util.DataTransferObject;
  
public class GameRound implements DataTransferObject
{
  private long gameId;  //Id of game being played
  private int turnNumber; //Current turn
  private String playerTurn;  //Which player's turn it is
  private String playerChoice;  //choice of player (attack or transfer)
  
  private String target;  //target of player (which hand they chose)
  
  private String handUsed;  //which hand the player used for action
  private int actionAmount; //the action amount (how much the player attacked for or how much they transferred)
  
  private int p1LeftHand; //Value of player 1 left hand
  private int p1RightHand;  //Value of player 1 right hand
  private int p2LeftHand; //Value of player 2 left hand
  private int p2RightHand;  //Value of player 2 right hand
  
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
  
  //Turn Number get and set
  public int getTurnNumber() 
  {
    return turnNumber;
  }
  public void setTurnNumber(int turnNumber)
  {
    this.turnNumber = turnNumber;
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
    
  //handUsed get and set
  public String getHandUsed() 
  {
    return handUsed;
  }
  public void setHandUsed(String handUsed)
  {
    this.handUsed = handUsed;
  }
  
  //action amount get and set
  public int getActionAmount() 
  {
    return actionAmount;
  }
  public void setActionAmount(int actionAmount)
  {
    this.actionAmount = actionAmount;
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
                ", handUsed='" + handUsed + '\'' +
                ", actionAmount='" + actionAmount + '\'' +
                ", p1LeftHand='" + p1LeftHand + '\'' +
                ", p1RightHand='" + p1RightHand + '\'' +
                ", p2LeftHand='" + p2LeftHand + '\'' +
                ", p2RightHand='" + p2RightHand + '\'' +
                '}';
  }
}

