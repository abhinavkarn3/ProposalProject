package com.abhinavmicroservice.projectproposals.repository;

import com.abhinavmicroservice.projectproposals.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByIdReturnsUserIfExists() {
        User user = new User();
        user.setName("Test User");
        user = userRepository.save(user);

        Optional<User> result = userRepository.findById(user.getId());
        assertTrue(result.isPresent());
        assertEquals("Test User", result.get().getName());
    }

    @Test
    void findByIdReturnsEmptyIfNotExists() {
        Optional<User> result = userRepository.findById(1L);
        assertFalse(result.isPresent());
    }

    @Test
    void saveUserSavesAndReturnsUser() {
        User user = new User();
        user.setName("Test User");

        User result = userRepository.save(user);
        assertNotNull(result);
        assertEquals("Test User", result.getName());
    }
}