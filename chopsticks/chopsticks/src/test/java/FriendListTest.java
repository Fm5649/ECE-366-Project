import com.teamchop.chopsticks.FriendList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DisplayName("Test Friend List class")
public class FriendListTest {
  private FriendList friendList;

  @BeforeEach
  void setup() {
    friendList = new FriendList();
    friendList.setUserId(50L);
    friendList.setUsername("person");
    friendList.setIdToken("player1");
  }
  @Test
    @DisplayName("Get ID successfully")
    public void testGetUserId() {
        assertEquals(50L, friendList.getUserId());
    }
  @Test
    @DisplayName("Get username successfully")
    public void testGetUserName() {
        assertEquals("person", friendList.getUsername());
    }
  @Test
    @DisplayName("Get IdToken successfully")
    public void testGetIdToken() {
        assertEquals("player1", friendList.getIdToken());
    }
  @Test
    public void testToString(){
            assertEquals("FriendList{userId=50, username='person'}",friendList.toString());
    }
}
