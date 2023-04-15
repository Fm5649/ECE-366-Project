--sql file for friendlist entries

\c chopsticks

CREATE TABLE friend_list(
  friendlist_username varchar(30) NOT NULL,
  friendlist_player_id bigint NOT NULL,
  FOREIGN KEY (friendlist_player_id) REFERENCES player(player_id) ON DELETE CASCADE
);
