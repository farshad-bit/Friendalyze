// backend/user-service/src/test/java/com/example/friendalyze/repository/ UserRepositoryTest.java


package com.example.friendalyze.repository;

import com.example.friendalyze.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest // Loads only repository layer for testing with an in-memory DB like H2
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    void setUp() {
        // Creating a test user before each test
        testUser = new User(null, "testUser", "test@example.com");
        userRepository.save(testUser);
    }

    @AfterEach
    void tearDown() {
        // Cleaning up the database after each test
        userRepository.deleteAll();
    }

    @Test
    public void testSaveUser_Success() {
        User savedUser = userRepository.findById(testUser.getId()).orElse(null);
        assertNotNull(savedUser);
        assertEquals("testUser", savedUser.getUsername());
        assertEquals("test@example.com", savedUser.getEmail());
    }

    @Test
    public void testFindById_UserExists() {
        Optional<User> foundUser = userRepository.findById(testUser.getId());
        assertTrue(foundUser.isPresent());
        assertEquals("testUser", foundUser.get().getUsername());
    }

    @Test
    public void testFindById_UserNotExists() {
        Optional<User> foundUser = userRepository.findById(999L); // Non-existing ID
        assertFalse(foundUser.isPresent());
    }

    @Test
    public void testFindAll_UsersExist() {
        List<User> users = userRepository.findAll();
        assertFalse(users.isEmpty());
    }

    @Test
    public void testDeleteUser_Success() {
        userRepository.delete(testUser);
        Optional<User> deletedUser = userRepository.findById(testUser.getId());
        assertFalse(deletedUser.isPresent());
    }
}
