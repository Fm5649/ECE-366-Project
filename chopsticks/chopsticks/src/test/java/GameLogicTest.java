
import com.teamchop.chopsticks.GameLogic;
import com.teamchop.chopsticks.GameRound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DisplayName("Test Game Logic class")
public class GameLogicTest{
  
  private GameRound gameRound;
  private GameLogic gameLogic;
  
  @BeforeEach
  void setup(){
    gameRound = new GameRound();
    gameLogic = new GameLogic();
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
  }
        /*             
 @Test
    public void testValidMoves() {
        assertEquals(4, gameLogic.validMoves(gameRound));
    }*/
 @Test
    public void testIsValidMoves() {
        assertEquals(true, gameLogic.isValidMove(gameRound));
    }
  
 @Test
    public void testIsWinner() {
        assertEquals(0, gameLogic.winner(gameRound));
    }
                  
}

