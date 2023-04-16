package com.teamchop.chopsticks;

import com.teamchop.chopsticks.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class FriendListDAO extends DataAccessObject{

    public FriendListDAO(Connection connection) {
        super(connection);
    }
    
    private static final String GET_ONE_BY_ID = "SELECT friendlist_player_id, " +
            "friendlist_username," +
            "FROM friend_list WHERE friendlist_player_id=?";

    private static final String INSERT_FRIEND = "INSERT INTO " +
            "friend_list (friendlist_player_id, friendlist_username) " +
            "VALUES (?, ?)";

    public FriendList findById(long id) {
        FriendList friendlist = new FriendList();
        Leaderboard leaderboard = new Leaderboard();
        System.out.println(GET_ONE_BY_ID);
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE_BY_ID);) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                friendlist.setUsername(rs.getString("friendlist_username"));
                friendlist.setUserId(rs.getLong("friendlist_player_id"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return friendlist;
    }


    public FriendList insertFriend(String username, long userId) {
        FriendList friendlist = new FriendList();
        System.out.println(INSERT_FRIEND);
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT_FRIEND);) {
            statement.setString(1, username);
            statement.setLong(2, userId);
            statement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return friendlist;
    }
  //INSERT CODE HERE
}
