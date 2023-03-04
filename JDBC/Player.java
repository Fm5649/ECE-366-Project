

package //placeholder;

import //placeholder.util.DataTransferObject;
  
public class Player implements DataTransferObject
{
  
  private long playerId;
  private String userName;
  private String passWord;
  private int totalGames;
  private int totalWins;
  private int totalLosses;  
  private int ELO;
  
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
