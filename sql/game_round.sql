--SQL file for game rounds

CREATE TABLE game_round (
    game_id bigint NOT NULL,
    round_number int NOT NULL,
    turn_player_name varchar(30) NOT NULL, --Which users' turn it is
    player_choice varchar (50) NOT NULL, --Attack or transfer
    player_target varchar(50) NOT NULL, --"P1Hand1, P1Hand1, P2Hand1, P2Hand2" 
    p1_choice varchar(50) NOT NULL,
    p2_choice varchar(50) NOT NULL,
    
    player_action_amount int NOT NULL DEFAULT 0,  --Amount the player transfers or attacks with
    p1_hand1 int NOT NULL DEFAULT 5,    
    p1_hand2 int NOT NULL DEFAULT 5,    
    p2_hand1 int NOT NULL DEFAULT 5,
    p2_hand2 int NOT NULL DEFAULT 5,
    
    PRIMARY KEY (game_id, round_number),
    FOREIGN KEY (game_id) REFERENCES game(game_id) ON DELETE CASCADE
);