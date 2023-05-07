import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test GameDAO class")

public class GameDAOTest {
  
  @Test
    @DisplayName("Get Game ID successfully")
    public void testSetGameID() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
      
        Game game = insertGame(100,200)
        game.
    }
}
