Database Table Concept

Users

|Table Member|Variable Type|Default|
|---|---|---|
|UserId|BigInt|NOT NULL DEFAULT nextval|
|Username|VarChar(50)  |NOT NULL|
|Password|VarChar(50)  |NOT NULL|
|Total Games Played|Int    |0|
|Total Win|Int   |0|
|Total Loss|Int    |0|
|ELO|Int   |0|

Games

Note: Include variable for hands of players? 

|Table Member|Variable Type|Default|
|---|---|---|
|GameId|BigInt|NOT NULL DEFAULT nextval|
|player1_Id|BigInt| NOT NULL|
|player2_Id|BigInt|  NOT NULL|
|Winner ID|Int| NULL |
|Current Round|Int| Not NULL |
|Total Rounds|Int| Not NULL |

Game History

Note: Decide how player choices will be represented. Players can attack a hand or swap. Variable for swap or attack? Show value of each hand?

|Table Member|Variable Type|Default|
|---|---|---|
|GameId|BigInt||
|Round Number|Int||
|Player1_Choice|||
|Player2_Choice|||
