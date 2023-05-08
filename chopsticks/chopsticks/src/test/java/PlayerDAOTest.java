import com.teamchop.chopsticks.PlayerDAO;
import com.teamchop.chopsticks.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DisplayName("Test PlayerDAO class")
public class PlayerDAOTest {

  private Player player;
  private PlayerDAO playerDAO

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
    @DisplayName("Delete player by id successfully")
    public void testGetPlayerId() {
        assertEquals(player, playerDAO.deleteById(100));
    }
}
