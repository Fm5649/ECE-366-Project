import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test PlayerDAO class")
public class PlayerDAOMockitoTest {
  
  @Mock
  PlayerDAO playerDAO
    
  @BeforeEach
  public void setupMocks() {
        Mockito.when().thenReturn();
    }  
  
  @Test
    @DisplayName("Create Player successfully")
    public void testWithdraw() {
        Player player = PlayerDAO.insertUserName("testing@cooper.edu" , "testing", "testingPassword") 
      
        assertEquals(200, bankAccount.getBalance());
    }
}
