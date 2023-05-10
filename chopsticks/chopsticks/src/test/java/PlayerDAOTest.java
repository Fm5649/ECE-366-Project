import com.teamchop.chopsticks.PlayerDAO;
import com.teamchop.chopsticks.Player;
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
@DisplayName("Test PlayerDAO class")
public class PlayerDAOTest {

  @Mock
  private PlayerDAO playerDAO;
    private Player player;
  
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
  public void setupMocks() {
        Mockito.when(playerDAO.deleteById(100)).thenReturn(player);      
        Mockito.when(playerDAO.updateStats(player)).thenReturn(player);
        Mockito.when(playerDAO.findById(100)).thenReturn(player);
        Mockito.when(playerDAO.findByUserName("tester")).thenReturn(player);
        Mockito.when(playerDAO.insertUserName("testing@cooper.edu","tester","testing","250")).thenReturn(player);
    }
  @Test
    @DisplayName("Delete player by id successfully")
    public void testGetPlayerId() {
        assertEquals(player, playerDAO.deleteById(100));
    }
  @Test
    @DisplayName("Update Player successfully")
    public void testUpdateStats() {
        assertEquals(player, playerDAO.updateStats(player));
    }
  @Test
    @DisplayName("Find by id successfully")
    public void testFindById() {
        assertEquals(player, playerDAO.findById(100));
    }
  @Test
    @DisplayName("Find by username successfully")
    public void testFindByUserName() {
        assertEquals(player, playerDAO.findByUserName("tester"));
    }
  @Test
    @DisplayName("insert Player successfully")
    public void testInsertPlayer(){
        assertEquals(player, playerDAO.insertUserName("testing@cooper.edu","tester","testing","250"));
                     }                
}
