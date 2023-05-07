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
    @DisplayName("Get ID successfully")
    public void testGetGameId() {
        assertEquals(15, game.getGameId());
    }
    @Test
    @DisplayName("Get round number successfully")
    public void testGetRoundNumber() {
        assertEquals(4, game.getRoundNumber());
    }
    @Test
    @DisplayName("Get player turn successfully")
    public void testGetPlayerTurn() {
        assertEquals("player1", game.getPlayerTurn());
    }
    @Test
    @DisplayName("Get player choice successfully")
    public void testGetPlayerChoice() {
        assertEquals("Attack", game.getPlayerChoice());
    }
    @Test
    @DisplayName("Get player hand used successfully")
    public void testGetPlayerHandUsed() {
        assertEquals("left", game.getPlayerHandUsed());
    }
    @Test
    @DisplayName("Get target successfully")
    public void testGetTarget() {
        assertEquals("right", game.getTarget());
    }
    @Test
    @DisplayName("Get action amount successfully")
    public void testGetAmount() {
        assertEquals(3, game.getAmount());
    }
    @Test
    @DisplayName("Get p1 hand 1 successfully")
    public void testGetP1Hand1() {
        assertEquals(3, game.getP1Hand1());
    }
    @Test
    @DisplayName("Get p1 hand 2 successfully")
    public void testGetP1Hand2() {
        assertEquals(2, game.getP1Hand2());
    }
    @Test
    @DisplayName("Get p2 hand 1 successfully")
    public void testGetP2Hand1() {
        assertEquals(1, game.getP2Hand1());
    }
    @Test
    @DisplayName("Get p2 hand 2 successfully")
    public void testGetP2Hand2() {
        assertEquals(4, game.getP2Hand2());
    }
}

