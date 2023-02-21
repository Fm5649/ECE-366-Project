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

|Table Member|Variable Type|Default|
|---|---|---|
|GameId|BigInt|NOT NULL DEFAULT nextval|
|player1_Id|BigInt| |
|player2_Id|BigInt|  |
|Winner|Int|  |
|Rounds|Int|  |

Game History

Note: Decide how player choices will be represented. Players can attack a hand or swap. Variable for swap or attack? Show value of each hand?

|Table Member|Variable Type|Default|
|---|---|---|
|GameId|BigInt||
|Round Number|Int||
|Player1_Choice|||
|Player2_Choice|||
