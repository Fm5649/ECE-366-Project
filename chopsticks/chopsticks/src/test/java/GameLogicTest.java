import com.teamchop.chopsticks.GameLogic;
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
  @Mock
    gameLogic = new GameLogic();
  
  @BeforeEach
    public void setupMocks() {
        Mockito.when(gameLogic.validMoves("g")).thenReturn(4);
        Mockito.when(gameLogic.isValidMove("d").thenReturn(5);
        Mockito.when(gameLogic.winner("c").thenReturn(1);      
    }
                     
 @Test
    public void testValidMoves() {
        assertEquals(4, calculateMethods.divide("g"));
    }
 @Test
    public void testIsValidMoves() {
        assertEquals(5, calculateMethods.divide("d"));
    }
 @Test
    public void testIsWinner() {
        assertEquals(1, calculateMethods.divide("c"));
    }
                  
}
