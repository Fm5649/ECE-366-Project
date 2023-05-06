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
In the course of developing this project, we have sought to follow the Software Engineering Code of Ethics and Professional Practice.

    1.01. Accept full responsibility for their own work.
    
As the creators of this project we take full responsibility for the creation and development of this project.

    2.02.  Not knowingly use software that is obtained or retained either illegally or unethically.
    
Our project does not use any software that was illegaly or unethically obtained. All software used is freely available.

    3.02. Ensure proper and achievable goals and objectives for any project on which they work or propose.
    
In the process of developing this project we have made sure that our goals and objectives are within reach with accordance to our own abilities.

    7.02. Assist colleagues in professional development.
    
This project was a group effort, and it required all of us to help one another with development.

    8.01. Further their knowledge of developments in the analysis, specification, design, development, maintenance and testing of software and related documents, together with the management of the development process.
    
Our work on this project has greatly contirbued to our won understanding of the software development process and the actions and steps required.


