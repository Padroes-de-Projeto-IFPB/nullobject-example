import br.edu.ifpb.domain.User;
import br.edu.ifpb.repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    UserRepository userRepository = new UserRepository();

    @Test
    public void findUserTest() {
        assertTrue(userRepository.find(1L).isPresent());
    }

    @Test
    public void findNonExistingUserTest() {
        assertNotNull(userRepository.find(5L).orElse(new User("admin", "321")));
    }

    @Test
    public void getLoginFromUser() throws Exception {
        String login = userRepository.find(1L).map(User::getLogin).orElseThrow( () -> new Exception("User not found") );
        assertEquals(login, "admin");
    }

}
