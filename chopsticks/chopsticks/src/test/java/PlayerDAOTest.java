import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test PlayerDAO class")
public class PlayerDAOTest {
  @Test
    @DisplayName("Create Player successfully")
    public void testWithdraw() {
        Player player = PlayerDAO.insertUserName("testing@cooper.edu" , "testing", "testingPassword") 
      
        assertEquals(200, bankAccount.getBalance());
    }
}
