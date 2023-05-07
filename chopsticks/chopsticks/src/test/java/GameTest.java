import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Game class")
public class GameTest {
  @BeforeAll
  Game game;
  game.setGameId(10);
  game.setPlayerOneId(12);
  game.setPlayerTwoId(24);
  game.setWinner(12);
  game.setPlayerOneName("player1");
  game.setPlayerTwoName("secondMan");
  
 @Test
    @DisplayName("Get ID successfully")
    public void testGetGameId() {
        assertEquals(10, game.getGameId());
    }
  @Test
    @DisplayName("Get Player One ID successfully")
    public void testGetPlayerOneId() {
        assertEquals(10, game.getPlayerOneId());
    }
    @Test
    @DisplayName("Get Player Two ID successfully")
    public void testGetPlayerTwoId() {
        assertEquals(10, game.getPlayerTwoId());
    }
    @Test
    @DisplayName("Get Winner ID successfully")
    public void testGetWinner() {
        assertEquals(10, game.getWinner());
    }
    @Test
    @DisplayName("Get Player One username successfully")
    public void testGetPlayerOneName() {
        assertEquals(10, game.getPlayerOneName());
    }
    @Test
    @DisplayName("Get Player Two username successfully")
    public void testGetPlayerTwoName() {
        assertEquals(10, game.getPlayerTwoName());
    }
}

