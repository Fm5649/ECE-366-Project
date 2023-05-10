import com.teamchop.chopsticks.LeaderboardDAO;
import com.teamchop.chopsticks.Leaderboard;
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
@DisplayName("Test LeaderboardDAO class")
public class LeaderboardDAOTest {
  @Mock
  private LeaderboardDAO leaderboardDAO;
    private Leaderboard leaderboard;
  
  void setup() {
    leaderboard = new Leaderboard();
    leaderboard.setUserId(50L);
    leaderboard.setRank(1);
    leaderboard.setUsername("player1");
    leaderboard.setWins(1000);
    leaderboard.setLosses(0);
    leaderboard.setTotalGames(1000);
    leaderboard.setElo(2500);
  }
  public void setupMocks() {    
        Mockito.when(leaderboardDAO.findById(50L)).thenReturn(leaderboard);
        Mockito.when(leaderboardDAO.insertLeaderboard(1,"player1",1000,0,1000,2500,50L)).thenReturn(leaderboard);
  }
  @Test
    @DisplayName("Find by id successfully")
    public void testFindById() {
        assertEquals(leaderboard, leaderboardDAO.findById(50L));
    }
  @Test
    @DisplayName("insert successfully")
    public void testInsertLeaderboard() {
        assertEquals((leaderboard, leaderboardDAO.insertLeaderboard(1,"player1",1000,0,1000,2500,50L));
    }
}
