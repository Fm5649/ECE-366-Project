/*
SQL file for game database

NOTE: Should have mechanism for keeping score: figure this out with group!
Variable for each hand: 5 points each
  Example: p1_right_hand int DEFAULT 5
Variable for total points: 10 total
  Example: p1_score int DEFAULT 10
*/

\c chopsticks

CREATE SEQUENCE game_seq start with 1;

CREATE TABLE game(
  game_id bigint NOT NULL DEFAULT nextval('game_seq'),
  p1_id bigint NOT NULL,
  p2_id bigint NOT NULL,
  --total_rounds int NOT NULL,
  --current_round int NOT NULL,
  winner_id bigint DEFAULT NULL,
  PRIMARY KEY (game_id),
  FOREIGN KEY (p1_id) REFERENCES player(player_id) ON DELETE CASCADE,
  FOREIGN KEY (p2_id) REFERENCES player(player_id) ON DELETE CASCADE,
  CHECK (p1_id <> p2_id),
  CHECK (winner_id = p1_id OR winner_id = p2_id)
);  