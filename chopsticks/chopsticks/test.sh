curl -X POST -H "Content-Type: application/json" -d "{\"userName\":\"testing\",\"password\":\"apassword\"}" http://localhost:8080/insertPlayer 

curl -X POST -H "Content-Type: application/json" -d "{\"userName\":\"playerOne\",\"password\":\"passwordOne\"}" http://localhost:8080/insertPlayer

curl -X POST -H "Content-Type: application/json" -d "{\"userName\":\"playerTwo\",\"password\":\"passwordTwo\"}" http://localhost:8080/insertPlayer

curl -X POST -H "Content-Type: application/json" -d "{\"id\":\"2\"}" http://localhost:8080/getPlayerById

curl -X POST -H "Content-Type: application/json" -d "{\"id\":\"3\"}" http://localhost:8080/getPlayerById

curl -X POST -H "Content-Type: application/json" -d "{\"p1Id\":\"2\",\"p2Id\":\"3\"}" http://localhost:8080/insertGame

curl -X POST -H "Content-Type: application/json" -d "{\"id\":\"1\"}" http://localhost:8080/getGameById

curl -X POST -H "Content-Type: application/json" -d "{\"gameId\":\"1\",\"playerTurn\":\"playerOne\",\"playerChoice\":\"Attack\",\"amount\":\"1\",\"playerHandUsed\":\"p1Hand1\",\"target\":\"p2Hand1\",\"p1Hand1\":\"1\",\"p1Hand2\":\"1\",\"p2Hand1\":\"1\",\"p2Hand2\":\"1\",\"roundNumber\":\"1\"}" http://localhost:8080/insertGameRound

curl -X POST -H "Content-Type: application/json" -d "{\"gameId\":\"1\",\"playerTurn\":\"playerTwo\",\"playerChoice\":\"Attack\",\"amount\":\"2\",\"playerHandUsed\":\"p2Hand1\",\"target\":\"p1Hand2\",\"p1Hand1\":\"1\",\"p1Hand2\":\"1\",\"p2Hand1\":\"2\",\"p2Hand2\":\"1\",\"roundNumber\":\"2\"}" http://localhost:8080/insertGameRound

curl -X POST -H "Content-Type: application/json" -d "{\"gameId\":\"1\",\"playerTurn\":\"playerOne\",\"playerChoice\":\"Transfer\",\"amount\":\"1\",\"playerHandUsed\":\"p1Hand1\",\"target\":\"p1Hand2\",\"p1Hand1\":\"1\",\"p1Hand2\":\"3\",\"p2Hand1\":\"2\",\"p2Hand2\":\"1\",\"roundNumber\":\"3\"}" http://localhost:8080/insertGameRound

curl -X POST -H "Content-Type: application/json" -d "{\"gameId\":\"1\",\"playerTurn\":\"playerTwo\",\"playerChoice\":\"Attack\",\"amount\":\"1\",\"playerHandUsed\":\"p2Hand2\",\"target\":\"p1Hand2\",\"p1Hand1\":\"1\",\"p1Hand2\":\"4\",\"p2Hand1\":\"2\",\"p2Hand2\":\"1\",\"roundNumber\":\"3\"}" http://localhost:8080/insertGameRound

curl -X POST -H "Content-Type: application/json" -d "{\"gameId\":\"10\",\"playerTurn\":\"Jang\",\"playerChoice\":\"Attack\",\"amount\":\"2\",\"playerHandUsed\":\"p2Hand1\",\"target\":\"p1Hand1\",\"p1Hand1\":\"3\",\"p1Hand2\":\"1\",\"p2Hand1\":\"2\",\"p2Hand2\":\"1\",\"roundNumber\":\"2\"}" http://localhost:8080/insertGameRound
