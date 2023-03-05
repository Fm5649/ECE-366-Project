

package com.chopsticks.lil.jdbc;

import com.chopsticks.lil.jdbc.util.DataTransferObject;
  
public class Player implements DataTransferObject
{
  
  private long playerId;  //ID of the player
  private String userName;  //username of the player
  private String passWord;  //password of the player
  private int totalGames; //total games won by player
  private int totalWins;  //total wins
  private int totalLosses;   //total losses
  private int ELO;  //ELO of the player
  
  //PlayerId get and set
  public long getId() 
  {
    return playerId;
  }
  public long getPlayerId() 
  {
    return playerId;
  }
  public void setPlayerId(long playerId)
  {
    this.playerId = playerId;
  }
  
  //UserName get and set
  public String getUserName()
  {
    return userName;
  } 
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  //PassWord get and set
  public String getPassWord()
  {
    return passWord;
  }
  public void setPassWord(String passWord)
  {
    this.passWord = passWord;
  }
  
  //TotalGames get and set
  public int getTotalGames()
  {
    return totalGames;
  }
  public void setTotalGames(int totalGames)
  {
    this.totalGames = totalGames;
  }
  
  //TotalWins get and set
  public int getTotalWins()
  {
    return totalWins;
  }
  public void setTotalWins(int totalWins)
  {
    this.totalWins = totalWins;
  }
  
  //TotalLosses get and set
  public int getTotalLosses()
  {
    return totalLosses;
  }
  public void setTotalLosses(int totalLosses)
  {
    this.totalLosses = totalLosses;
  }
  
  //ELO get and set
  public int getELO()
  {
    return ELO;
  }
  public void setELO(int ELO)
  {
    this.ELO = ELO;
  }
  
  @Override
  public String toString() 
  {
      return "Player{" +
                "playerId=" + playerId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", totalGames='" + totalGames + '\'' +
                ", totalWins='" + totalWins + '\'' +
                ", totalLosses='" + totalLosses + '\'' +
                ", ELO='" + ELO + '\'' +
                '}';
  }
}
