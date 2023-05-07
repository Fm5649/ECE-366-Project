import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Player class")
public class PlayerTest {
  @BeforeAll
  Player player;
  player.setPlayerId(100);
  player.setPlayerEmail("testing@cooper.edu");
  player.setPlayerName("tester");
  player.setPassword("testing");
  player.setTotalGames(10);
  player.setTotalWins(7);
  player.setTotalLosses(3);
  player.setPlayerELO(1000);
  
  @Test
    @DisplayName("Get ID successfully")
    public void testGetPlayerId() {
        assertEquals(100, player.getPlayerId());
    }
  @Test
    @DisplayName("Get Email successfully")
    public void testGetPlayerEmail() {
        assertEquals(100, player.getPlayerEmail());
    }
  @Test
    @DisplayName("Get UserName successfully")
    public void testGetPlayerName() {
        assertEquals(100, player.getPlayerName());
    }
  @Test
    @DisplayName("Get Password successfully")
    public void testGetPassword() {
        assertEquals(100, player.getPassword());
    }
  @Test
    @DisplayName("Get TotalGames successfully")
    public void testGetTotalGames() {
        assertEquals(100, player.getTotalGames());
    }
  @Test
    @DisplayName("Get TotalWins successfully")
    public void testGetTotalWins() {
        assertEquals(100, player.getTotalWins());
    }
  @Test
    @DisplayName("Get TotalLosses successfully")
    public void testGetTotalLosses() {
        assertEquals(100, player.getTotalLosses());
    }
  @Test
    @DisplayName("Get ELO successfully")
    public void testGetPlayerElo() {
        assertEquals(100, player.getPlayerElo());
    }
}
