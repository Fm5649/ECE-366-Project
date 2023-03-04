INSERT INTO player (player_name, password) VALUES ('Allen', 'Tiger');
INSERT INTO player (player_name, password) VALUES ('Tszhim', 'Miszka');
INSERT INTO player (player_name, password) VALUES ('Jang', 'Kropka');
INSERT INTO player (player_name, password) VALUES ('Haseeb', 'Czarna');
INSERT INTO player (player_name, password) VALUES ('Raymond', 'Biala');
INSERT INTO game (p1_id, p2_id, winner_id) VALUES (1, 2, 1);
INSERT INTO game_round(game_id, round_number, turn_player_name, player_choice, player_target, player_action_amount, p1_hand1, p1_hand2, p2_hand1, p2_hand2) VALUES (1, 1, 'Allen', 'Attack', 'P2Hand2', 1, 1, 1, 1, 2);
INSERT INTO game_round(game_id, round_number, turn_player_name, player_choice, player_target, player_action_amount, p1_hand1, p1_hand2, p2_hand1, p2_hand2) VALUES (1, 2, 'Tszhim', 'Attack', 'P1Hand1', 2, 3, 1, 1, 2);
INSERT INTO game_round(game_id, round_number, turn_player_name, player_choice, player_target, player_action_amount, p1_hand1, p1_hand2, p2_hand1, p2_hand2) VALUES (1, 3, 'Allen', 'Attack', 'P2Hand2', 3, 3, 1, 1, 5);
INSERT INTO game_round(game_id, round_number, turn_player_name, player_choice, player_target, player_action_amount, p1_hand1, p1_hand2, p2_hand1, p2_hand2) VALUES (1, 4, 'Tszhim', 'Attack', 'P1Hand2', 1, 3, 2, 1, 5);
INSERT INTO game_round(game_id, round_number, turn_player_name, player_choice, player_target, player_action_amount, p1_hand1, p1_hand2, p2_hand1, p2_hand2) VALUES (1, 5, 'Allen', 'Transfer', 'P1Hand2', 2, 1, 4, 1, 5);
INSERT INTO game_round(game_id, round_number, turn_player_name, player_choice, player_target, player_action_amount, p1_hand1, p1_hand2, p2_hand1, p2_hand2) VALUES (1, 6, 'Tszhim', 'Attack', 'P1Hand2', 1, 1, 5, 1, 5);
INSERT INTO game_round(game_id, round_number, turn_player_name, player_choice, player_target, player_action_amount, p1_hand1, p1_hand2, p2_hand1, p2_hand2) VALUES (1, 7, 'Allen', 'Attack', 'P1Hand2', 1, 1, 5, 2, 5);
INSERT INTO game_round(game_id, round_number, turn_player_name, player_choice, player_target, player_action_amount, p1_hand1, p1_hand2, p2_hand1, p2_hand2) VALUES (1, 8, 'Tszhim', 'Attack', 'P1Hand2', 2, 3, 5, 2, 5);
INSERT INTO game_round(game_id, round_number, turn_player_name, player_choice, player_target, player_action_amount, p1_hand1, p1_hand2, p2_hand1, p2_hand2) VALUES (1, 8, 'Allen', 'Attack', 'P1Hand2', 3, 3, 5, 5, 5);
