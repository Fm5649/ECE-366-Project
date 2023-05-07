import com.teamchop.chopsticks.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DisplayName("Test Game class")
public class GameTest {

  private Game game;

  @BeforeEach
  void setup() {
    game = new Game();
    game.setGameId(10);
    game.setPlayerOneId(12);
    game.setPlayerTwoId(24);
    game.setWinner(12);
    game.setPlayerOneName("player1");
    game.setPlayerTwoName("secondMan");
  }
  
 @Test
    @DisplayName("Get ID successfully")
    public void testGetGameId() {
        assertEquals(10, game.getGameId());
    }
  @Test
    @DisplayName("Get Player One ID successfully")
    public void testGetPlayerOneId() {
        assertEquals(12, game.getPlayerOneId());
    }
    @Test
    @DisplayName("Get Player Two ID successfully")
    public void testGetPlayerTwoId() {
        assertEquals(24, game.getPlayerTwoId());
    }
    @Test
    @DisplayName("Get Winner ID successfully")
    public void testGetWinner() {
        assertEquals(12, game.getWinner());
    }
    @Test
    @DisplayName("Get Player One username successfully")
    public void testGetPlayerOneName() {
        assertEquals("player1", game.getPlayerOneName());
    }
    @Test
    @DisplayName("Get Player Two username successfully")
    public void testGetPlayerTwoName() {
        assertEquals("secondMan", game.getPlayerTwoName());
    }
}

