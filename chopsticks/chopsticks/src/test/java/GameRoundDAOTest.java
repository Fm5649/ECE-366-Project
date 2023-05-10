import com.teamchop.chopsticks.GameRoundDAO;
import com.teamchop.chopsticks.GameRound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@DisplayName("Test GameRoundDAO class")
public class GameRoundDAOTest {
  @Mock
  private GameRoundDAO gameRoundDAO;
    private GameRound gameRound;
  
  void setup() {
    gameRound = new GameRound();
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
  public void setupMocks() {
    Mockito.when(gameRoundDAO.updateHands(gameRound)).thenReturn(gameRound);
    Mockito.when(gameRoundDAO.findById(15)).thenReturn(gameRound);
    Mockito.when(gameRoundDAO.insertGameRound(15L,4,"player1","Attack","left","right",3,3,2,1,4)).thenReturn(gameRound);
  }
  @Test
    @DisplayName("Update hands successfully")
    public void testUpdateHands() {
        assertEquals(gameRound, gameRoundDAO.updateHands(gameRound));
    }
  @Test
    @DisplayName("find by id successfully")
    public void testFindById() {
        assertEquals(gameRound, gameRoundDAO.findById(15));
    }
  @Test
    @DisplayName("insert round successfully")
    public void testInsertGameRound() {
        assertEquals(gameRound, gameRoundDAO.insertGameRound(15L,4,"player1","Attack","left","right",3,3,2,1,4));
    }
}
