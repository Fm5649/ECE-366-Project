--sql file for leaderboard entries

\c chopsticks

CREATE TABLE leaderboard(
  leaderboard_rank int DEFAULT 0,
  leaderboard_username varchar(30) NOT NULL,
  leaderboard_wins int DEFAULT 0,
  leaderboard_losses int DEFAULT 0,
  leaderboard_total_games int DEFAULT 0,
  leaderboard_elo int DEFAULT 0,
  leaderboard_player_id bigint NOT NULL,
  FOREIGN KEY (leaderboard_player_id) REFERENCES player(player_id) ON DELETE CASCADE
);
