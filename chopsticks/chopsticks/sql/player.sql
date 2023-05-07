--File to create database table for user

--IMPORTANT: CHANGED USER -> PLAYER 

\c chopsticks

CREATE SEQUENCE player_seq start with 1;

CREATE TABLE player (
  player_id bigint NOT NULL DEFAULT nextval('player_seq'),  --id of the player
  player_email varchar(30) NOT NULL,  --email of the player
  player_name varchar(30) NOT NULL,   --username of the player
  password varchar(30) NOT NULL,  --password of the player
  total_games int DEFAULT 0,  --total number of games played
  total_wins int DEFAULT 0,   --total wins
  total_losses int DEFAULT 0,   --total losses
  player_elo int DEFAULT 1000,  --elo of player
  achievement_first_win int DEFAULT 0,  --variable for achievement of winning one game
  achievement_first_game int DEFAULT 0,   --variable for achievement of playing one game
  PRIMARY KEY (player_id)
);

--Added achievements to player

insert into player (player_name, player_email, "password") values ('test','test','password');
insert into player (player_name, player_email, "password") values ('test2','test2','password');
insert into player (player_name, player_email, "password") values ('test3','test3','password');
