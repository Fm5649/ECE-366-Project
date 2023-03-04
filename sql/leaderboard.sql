--sql file for leaderboard entries

CREATE TABLE leaderboard(
  leaderboard_rank int DEFAULT 0,
  leaderboard_username varchar(30) NOT NULL,
  leaderboard_wins int DEFAULT 0,
  leaderboard_losses int DEFAULT 0,
  leaderboard_total_games int DEFAULT 0,
  leaderboard_elo int DEFAULT 0,
  PRIMARY KEY (leaderboard_username),
  FOREIGN KEY (leaderboard_username) REFERENCES player(player_name) ON DELETE CASCADE,
  FOREIGN KEY (leaderboard_wins) REFERENCES player(total_wins) ON DELETE CASCADE,
  FOREIGN KEY (leaderboard_losses) REFERENCES player(total_losses) ON DELETE CASCADE,
  FOREIGN KEY (leaderboard_total_games) REFERENCES player(total_games) ON DELETE CASCADE,
  FOREIGN KEY (leaderboard_elo) REFERENCES player(player_elo) ON DELETE CASCADE
);
