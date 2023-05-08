/*
import com.teamchop.chopsticks.GameLogic;
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
@DisplayName("Test Game Logic class")
public class GameLogicTest{
  
  private GameRound gameRound;
  @Mock
    GameLogic gameLogic;
  
  @BeforeEach
    public void setupMocks() {
        //Mockito.when(gameLogic.validMoves(gameRound)).thenReturn(4);
        //Mockito.when(gameLogic.isValidMove(gameRound)).thenReturn(5);
        Mockito.when(gameLogic.winner(gameRound)).thenReturn(1);      
    }
                     
 @Test
    public void testValidMoves() {
        assertEquals(4, gameLogic.validMoves(gameRound));
    }
 @Test
    public void testIsValidMoves() {
        assertEquals(5, gameLogic.isValidMove(gameRound));
    }
  
 @Test
    public void testIsWinner() {
        assertEquals(1, gameLogic.winner(gameRound));
    }
                  
}
*/
