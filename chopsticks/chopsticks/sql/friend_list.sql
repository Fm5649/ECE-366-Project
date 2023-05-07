--sql file for friendlist entries

\c chopsticks

CREATE TABLE friend_list(
  friendlist_id bigint NOT NULL,
  friendlist_player_id bigint NOT NULL,
  FOREIGN KEY (friendlist_id) REFERENCES player(player_id) ON DELETE CASCADE,
);
