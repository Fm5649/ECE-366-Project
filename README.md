Chopsticks Game
---------------------------------------------
Enter the ECE-366-Project/chopsticks/chopsticks directory   
Command:  
    cd chopsticks/chopsticks  

Files are setup to create the database and setup spring boot using docker compose. The sql files are copied to the docker-entrypoint-initdb.d directory in the chopsticks-db-1 container. The sql files are run to create the database "chopsticks" and the necessary tables and sequences.  
Command:  
    docker compose build  
    docker compose up  

The shell script used for testing can then be run:  
Command:    
    bash test.sh    

This shell script uses the CRUD operations to create three players, return the information of two players, update a player, delete a player, create a game, return the game, and lasty create 4 instances of a game round (this is done in this order). View shell.sh for example curl commands that use http requests to access the created CRUD operations.   

The tables can be viewed by accessing the psql terminal in the ubuntu terminal: 
Commands:   
    docker exec -it chopsticks-db-1 psql -h localhost -U postgres   
    \c chopsticks   
    \dt 
    \ds 
    SELECT * FROM player;   
    SELECT * FROM game; 
    SELECT * FROM game_round;   
    SELECT * FROM leaderboard;  
    
**Project Ethics**
---------------------------------------------
