--File to create database table for user

--IMPORTANT: CHANGED USER -> PLAYER 

\c chopsticks

CREATE SEQUENCE player_seq start with 1;

CREATE TABLE player (
  player_id bigint NOT NULL DEFAULT nextval('player_seq'),
  player_email varchar(30) NOT NULL,
  player_name varchar(30) NOT NULL,
  password varchar(30) NOT NULL,
  total_games int DEFAULT 0,
  total_wins int DEFAULT 0,
  total_losses int DEFAULT 0,
  player_elo int DEFAULT 1000,
  achievement_first_win int DEFAULT 0,  
  achievement_first_game int DEFAULT 0,
  PRIMARY KEY (player_id)
);

--Added achievements to player

insert into player (player_name, player_email, "password") values ('test','test','password');
insert into player (player_name, player_email, "password") values ('test2','test2','password');
insert into player (player_name, player_email, "password") values ('test3','test3','password');