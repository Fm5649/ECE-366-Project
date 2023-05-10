import com.teamchop.chopsticks.FriendListDAO;
import com.teamchop.chopsticks.FriendList;
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
@DisplayName("Test FriendListDAO class")
public class FriendListDAOTest {
  @Mock
  private FriendListDAO friendListDAO;
    private FriendList friendList;
  
  void setup() {
    friendList = new FriendList();
    friendList.setUserId(50L);
    friendList.setUsername("person");
    friendList.setIdToken("player1");
  }
  public void setupMocks() {    
        Mockito.when(friendListDAO.findById(50L)).thenReturn(friendList);
        Mockito.when(friendListDAO.insertFriend("person",50L)).thenReturn(friendList);
  }
  @Test
    @DisplayName("Find by id successfully")
    public void testFindById() {
        assertEquals(friendList, friendListDAO.findById(50L));
    }
  @Test
    @DisplayName("insert successfully")
    public void testInsertFriend() {
        assertEquals(friendList, friendListDAO.insertFriend("person",50L));
    }
}
