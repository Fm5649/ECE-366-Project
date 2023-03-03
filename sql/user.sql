--File to create database table for user

--IMPORTANT: CHANGED USER -> PLAYER 

CREATE SEQUENCE player_seq start with 1;

CREATE TABLE player (
  player_id bigint NOT NULL DEFAULT nextval('user_seq'),
  player_name varchar(30) NOT NULL,
  password varchar(30) NOT NULL,
  total_games int default 0,
  total_wins int default 0,
  total_losses int default 0,
  player_elo int default 0,
  PRIMARY KEY (user_id)
);