package com.teamchop.chopsticks;

import com.teamchop.chopsticks.util.DataTransferObject;

public class FriendList implements DataTransferObject
{
  private long userId;
  private String username;
  private String idToken;
  public String getIdToken() {
      return idToken;
  }
  public void setIdToken(String s) {idToken = s;}


  public long getId()
    {
        return userId;
    }
  public long getUserId() {
      return userId;
  }

  
  public void setUserId(Long userId) {
      this.userId = userId;
  }
  
  public String getUsername() {
      return username;
  }

  public void setUsername(String username) {
      this.username = username;
  }

  @Override
    public String toString() {
        return "FriendList{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}