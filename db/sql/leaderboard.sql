--sql file for leaderboard entries

\c chopsticks

CREATE TABLE leaderboard(
  leaderboard_rank int DEFAULT 0, --rank of player on leaderboard
  leaderboard_username varchar(30) NOT NULL,  --username of player
  leaderboard_wins int DEFAULT 0,   --number of wins of player
  leaderboard_losses int DEFAULT 0,   --number of losses
  leaderboard_total_games int DEFAULT 0,  --total games of player
  leaderboard_elo int DEFAULT 0,  --elo of player
  leaderboard_player_id bigint NOT NULL,  --id of the player
  FOREIGN KEY (leaderboard_player_id) REFERENCES player(player_id) ON DELETE CASCADE
);
