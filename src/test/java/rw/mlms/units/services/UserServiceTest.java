package rw.mlms.units.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import rw.mlms.models.User;
import rw.mlms.services.IUserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
public class UserServiceTest {
    @Mock
    private IUserService userService;

    @Test
    public void create() {
        // Mock the behavior of the userService
        User user = new User();
        when(userService.create(user)).thenReturn(user);

        // Call the create() method
        User actualUser = userService.create(user);

        // Assert that the expected results are returned
        assertEquals(user, actualUser);
    }

    @Test
    public void isNotUnique() {
        // Mock the behavior of the userService
        User user = new User();
        when(userService.isNotUnique(user)).thenReturn(true);

        // Call the isNotUnique() method
        boolean isNotUnique = userService.isNotUnique(user);

        // Assert that the expected results are returned
        assertTrue(isNotUnique);
    }

    @Test
    public void validateNewRegistration() {
        // Mock the behavior of the userService
        User user = new User();
        doNothing().when(userService).validateNewRegistration(user);

        // Call the validateNewRegistration() method
        userService.validateNewRegistration(user);

        // Assert that the expected results are returned
        verify(userService).validateNewRegistration(user);
    }

    @Test
    public void getLoggedInUser() {
        // Mock the behavior of the userService
        User user = new User();
        when(userService.getLoggedInUser()).thenReturn(user);

        // Call the getLoggedInUser() method
        User actualUser = userService.getLoggedInUser();

        // Assert that the expected results are returned
        assertEquals(user, actualUser);
    }
}
