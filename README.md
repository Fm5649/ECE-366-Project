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

**JaCoCo Testing**
---------------------------------------------
  ![Screenshot (58)](https://user-images.githubusercontent.com/100239942/236953758-265ebc5c-bd51-4cd6-b027-ce62eee15ac4.png)

 ![Screenshot (60)](https://user-images.githubusercontent.com/100239942/236953552-48c63a57-d18d-4766-80fa-fc03b36efe57.png)
![Screenshot (61)](https://user-images.githubusercontent.com/100239942/236953553-65d2f866-5180-42fb-8ae1-9098b8f3ce6e.png)
   
**Project Ethics**
---------------------------------------------
In the course of developing this project, we have sought to follow the Software Engineering Code of Ethics and Professional Practice.

    1.01. Accept full responsibility for their own work.
    
As the creators of this project we take full responsibility for the creation and development of this project.

    1.06. Be fair and avoid deception in all statements, particularly public ones, concerning software or related documents, methods and tools.
    
We have been open about the purpose of our project and have not tried to conceal or mislead the public about our software.

    2.02.  Not knowingly use software that is obtained or retained either illegally or unethically.
    
Our project does not use any software that was illegaly or unethically obtained. All software used is freely available.

    3.01. Strive for high quality, acceptable cost and a reasonable schedule, ensuring significant tradeoffs are clear to and accepted by the employer and the client, and are available for consideration by the user and the public.
    
We have sought to develop this product to the highest quality that we can achieve while staying on schedule and have made clear the potential risks and limitations in this product.

    3.02. Ensure proper and achievable goals and objectives for any project on which they work or propose.
    
In the process of developing this project we have made sure that our goals and objectives are within reach with accordance to our own abilities.

    4.01. Temper all technical judgments by the need to support and maintain human values.

We have not attempted to make technical decisions that run counter to human values or which could be harmful to users.

    6.07. Be accurate in stating the characteristics of software on which they work, avoiding not only false claims but also claims that might reasonably be supposed to be speculative, vacuous, deceptive, misleading, or doubtful.
    
We have not attempted to make false or misleading statements regarding our project, and have strived to be truthful about our project and our work.

    7.02. Assist colleagues in professional development.
    
This project was a group effort, and it required all of us to help one another with development.

    7.05. Give a fair hearing to the opinions, concerns, or complaints of a colleague.

We have not attempted to stifle dissent or disagreement, and have made modifications and improvements based on the opinions of one another.

    8.01. Further their knowledge of developments in the analysis, specification, design, development, maintenance and testing of software and related documents, together with the management of the development process.
    
Our work on this project has greatly contirbued to our won understanding of the software development process and the actions and steps required.


