--sql file for leaderboard entries

CREATE TABLE leaderboard(
  leaderboard_rank int default 0,
  leaderboard_username varchar(30) NOT NULL.
  leaderboard_wins int default 0,
  leaderboard_losses int default 0,
  leaderboard_total_games int default 0,
  leaderboard_elo int default 0,
  PRIMARY KEY (leaderboard_username),
  FOREIGN KEY (leaderboard_username) REFERENCES user(user_name) ON DELETE CASCADE,
  FOREIGN KEY (leaderboard_wins) REFERENCES user(total_wins) ON DELETE CASCADE,
  FOREIGN KEY (leaderboard_losses) REFERENCES user(total_losses) ON DELETE CASCADE,
  FOREIGN KEY (leaderboard_total_games) REFERENCES user(total_games) ON DELETE CASCADE,
  FOREIGN KEY (leaderboard_elo) REFERENCES user(user_elo) ON DELETE CASCADE
);