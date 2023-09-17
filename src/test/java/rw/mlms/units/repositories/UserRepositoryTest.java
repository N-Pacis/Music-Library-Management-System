package rw.mlms.units.repositories;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import rw.mlms.models.User;
import rw.mlms.repositories.IUserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
public class UserRepositoryTest {
    @Mock
    private IUserRepository userRepository;

    @Test
    public void save() {
        // Mock the behavior of the userRepository
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        // Call the save() method
        User actualUser = userRepository.save(user);

        // Assert that the expected results are returned
        assertEquals(user, actualUser);
    }

    @Test
    public void findByUsername() {
        // Mock the behavior of the userRepository
        User user = new User();
        when(userRepository.findByUsername("username")).thenReturn(Optional.of(user));

        // Call the findByUsername() method
        Optional<User> actualUser = userRepository.findByUsername("username");

        // Assert that the expected results are returned
        assertEquals(user, actualUser.get());
    }
}
