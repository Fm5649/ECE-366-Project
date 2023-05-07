import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Leaderboard class")
public class LeaderboardTest {
  @BeforeAll
  Leaderboard leaderboard;
  leaderboard.setUserId(50);
  leaderboard.setRank(1);
  leaderboard.setUsername("player1");
  leaderboard.setWins(1000);
  leaderboard.setLosses(0);
  leaderboard.setTotalGames(1000);
  leaderboard.setElo(2500);
  
  @Test
    @DisplayName("Get ID successfully")
    public void testGetUserId() {
        assertEquals(50, game.getUserId());
    }
  @Test
    @DisplayName("Get Rank successfully")
    public void testGetRank() {
        assertEquals(1, game.getRank());
    }
  @Test
    @DisplayName("Get username successfully")
    public void testGetUsername() {
        assertEquals("player1", game.getUsername());
    }
  @Test
    @DisplayName("Get wins successfully")
    public void testGetWins() {
        assertEquals(1000, game.getWins());
    }
  @Test
    @DisplayName("Get losses successfully")
    public void testGetLosses() {
        assertEquals(0, game.getLosses());
    }
  @Test
    @DisplayName("Get total games successfully")
    public void testGetTotalGames() {
        assertEquals(1000, game.getTotalGames());
    }
  @Test
    @DisplayName("Get ELO successfully")
    public void testGetElo() {
        assertEquals(2500, game.getElo());
    }
}
