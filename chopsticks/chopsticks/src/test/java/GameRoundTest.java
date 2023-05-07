import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test GameRound class")
public class GameRoundTest {
    
  @BeforeAll
  GameRound gameRound;  
  gameRound.setGameId(15);
  gameRound.setRoundNumber(4);
  gameRound.setPlayerTurn("player1");
  gameRound.setPlayerChoice("Attack"); 
  gameRound.setPlayerHandUsed("left");
  gameRound.setTarget("right");
  gameRound.setAmount(3);
  gameRound.setP1Hand1(3);
  gameRound.setP1Hand2(2);
  gameRound.setP2Hand1(1);
  gameRound.setP2Hand2(4);
  
  @Test
    @DisplayName("Create Player successfully")
    public void testWithdraw() {
        Player player = PlayerDAO.insertUserName("testing@cooper.edu" , "testing", "testingPassword") 
      
        assertEquals(200, bankAccount.getBalance());
    }
}

