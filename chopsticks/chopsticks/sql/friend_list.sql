--sql file for friendlist entries

\c chopsticks

CREATE TABLE friend_list(
  friendlist_username varchar(30) NOT NULL,   --username of the player friend
  friendlist_player_id bigint NOT NULL,   --id of the player friend
  FOREIGN KEY (friendlist_player_id) REFERENCES player(player_id) ON DELETE CASCADE
);
