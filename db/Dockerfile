FROM postgres

# Copy the SQL files to the container
COPY sql/init.sql /docker-entrypoint-initdb.d/0_init.sql
COPY sql/player.sql /docker-entrypoint-initdb.d/1_player.sql
COPY sql/game.sql /docker-entrypoint-initdb.d/2_game.sql
COPY sql/game_round.sql /docker-entrypoint-initdb.d/3_game_round.sql
COPY sql/leaderboard.sql /docker-entrypoint-initdb.d/4_leaderboard.sql
COPY sql/friend_list.sql /docker-entrypoint-initdb.d/5_friend_list.sql