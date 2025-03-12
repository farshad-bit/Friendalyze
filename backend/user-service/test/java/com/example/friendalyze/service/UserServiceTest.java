// backend/user-service/src/test/java/com/example/friendalyze/service/UserServiceTest.java

package com.example.friendalyze.service;

import com.example.friendalyze.model.User;
import com.example.friendalyze.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User(1L, "testUser", "test@example.com");
    }

    @Test
    public void testFindUserById_Success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));

        User user = userService.findUserById(1L);

        assertNotNull(user);
        assertEquals("testUser", user.getUsername());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindUserById_NotFound() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        User user = userService.findUserById(2L);

        assertNull(user);
        verify(userRepository, times(1)).findById(2L);
    }
}
