import com.teamchop.chopsticks.GameDAO;
import com.teamchop.chopsticks.Game;
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
@DisplayName("Test GameDAO class")
public class GameDAOTest {
  @Mock
  private GameDAO gameDAO;
    private Game game;
  
  void setup() {
    game = new Game();
    game.setGameId(10L);
    game.setPlayerOneId(12L);
    game.setPlayerTwoId(24L);
    game.setWinner(12L);
    game.setPlayerOneName("player1");
    game.setPlayerTwoName("secondMan");
  }
  public void setupMocks() {    
    Mockito.when(gameDAO.updateOpponent(10L,24L)).thenReturn(game);
        Mockito.when(gameDAO.findById(10L)).thenReturn(game);
        Mockito.when(gameDAO.insertGame(12L,24L)).thenReturn(game);
  }
  @Test
    @DisplayName("Find by id successfully")
    public void testFindById() {
        assertEquals(game, gameDAO.findById(10L));
    }
  @Test
    @DisplayName("insert successfully")
    public void testInsertGame(){
        assertEquals(game, gameDAO.insertGame(12L,24L));
                     }            
  @Test
    @DisplayName("Update opponent successfully")
    public void testUpdateOpponent() {
        assertEquals(game, gameDAO.updateOpponent(10L,24L));
    }
}
  
  
  
  
  



