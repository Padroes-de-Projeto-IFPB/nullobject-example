import br.edu.ifpb.domain.User;
import br.edu.ifpb.repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    UserRepository userRepository = new UserRepository();

    @Test
    public void findUserTest() throws Exception {
        Optional<User> usuario = userRepository.find(1L);
        User usuarioNulo = new User();
        usuarioNulo.setId(5L);
        usuarioNulo.setLogin("teste");
        usuarioNulo.setPassword("123");
        User user = usuario.orElse(usuarioNulo);
        usuario.orElseThrow( () -> new Exception("Usuario nao encontrado!"));
        User user2 = usuario.get();
        assertTrue(userRepository.find(1L).isPresent());
    }

    @Test
    public void findUserWithEncryptedPassword() {
        Optional<User> usuario = userRepository.find(1L);
        usuario.ifPresent(u -> {
            System.out.println(u.getLogin());
        });
        usuario.map( u -> {
           u.setPassword(u.getPassword().replace(u.getPassword(), "***"));
           return u;
        });
        assertTrue(usuario.isPresent());
        assertEquals("***", usuario.get().getPassword());
    }

    @Test
    public void findInactiveUser() {
        Optional<User> usuario = userRepository.find(1L);
        usuario = usuario.filter(User::isActive);
        assertTrue(usuario.isEmpty());
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
