import com.teamchop.chopsticks.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DisplayName("Test Player class")
public class PlayerTest {

  private Player player;

  @BeforeEach
  void setup() {
    player = new Player();
    player.setPlayerId(100);
    player.setPlayerEmail("testing@cooper.edu");
    player.setPlayerName("tester");
    player.setPassword("testing");
    player.setTotalGames(10);
    player.setTotalWins(7);
    player.setTotalLosses(3);
    player.setPlayerElo(1000);
  }

  @Test
    @DisplayName("Get ID successfully")
    public void testGetPlayerId() {
        assertEquals(100, player.getPlayerId());
    }
  @Test
    @DisplayName("Get Email successfully")
    public void testGetPlayerEmail() {
        assertEquals("testing@cooper.edu", player.getPlayerEmail());
    }
  @Test
    @DisplayName("Get UserName successfully")
    public void testGetPlayerName() {
        assertEquals("tester", player.getPlayerName());
    }
  @Test
    @DisplayName("Get Password successfully")
    public void testGetPassword() {
        assertEquals("testing", player.getPassword());
    }
  @Test
    @DisplayName("Get TotalGames successfully")
    public void testGetTotalGames() {
        assertEquals(10, player.getTotalGames());
    }
  @Test
    @DisplayName("Get TotalWins successfully")
    public void testGetTotalWins() {
        assertEquals(7, player.getTotalWins());
    }
  @Test
    @DisplayName("Get TotalLosses successfully")
    public void testGetTotalLosses() {
        assertEquals(3, player.getTotalLosses());
    }
  @Test
    @DisplayName("Get ELO successfully")
    public void testGetPlayerElo() {
        assertEquals(1000, player.getPlayerElo());
    }
  @Test
    public void testToString(){
            assertEquals("GameRound{playerId=100, playerEmail='testing@cooper.edu', playerName='tester', password='testing', totalGames=10, totalWins=7, totalLosses=3, playerELO=1000, achievementFirstWin=1, achievementFirstGame=1}",gameRound.toString());
    }
}
