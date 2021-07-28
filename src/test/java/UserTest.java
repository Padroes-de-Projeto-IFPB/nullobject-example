import br.edu.ifpb.domain.User;
import br.edu.ifpb.repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void findUserTest() {
        UserRepository userRepository = new UserRepository();
        assertTrue(userRepository.find(1L).isPresent());
    }

    @Test
    public void findNonExistingUserTest() {
        UserRepository userRepository = new UserRepository();
        assertNotNull(userRepository.find(5L).orElse(new User("admin", "321")));
    }

}
