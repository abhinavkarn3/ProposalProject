package com.abhinavmicroservice.projectproposals.service;

import com.abhinavmicroservice.projectproposals.entity.User;
import com.abhinavmicroservice.projectproposals.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsersReturnsListOfUsers() {
        User user = new User();
        user.setId(1L);
        user.setName("Test User");
        List<User> users = Collections.singletonList(user);

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();
        assertEquals(1, result.size());
        assertEquals("Test User", result.get(0).getName());
    }

    @Test
    void getUserByIdReturnsUserIfExists() {
        User user = new User();
        user.setId(1L);
        user.setName("Test User");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);
        assertNotNull(result);
        assertEquals("Test User", result.getName());
    }

    @Test
    void getUserByIdReturnsNullIfNotExists() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        User result = userService.getUserById(1L);
        assertNull(result);
    }

    @Test
    void saveUserSavesAndReturnsUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Test User");

        when(userRepository.save(user)).thenReturn(user);

        User result = userService.saveUser(user);
        assertNotNull(result);
        assertEquals("Test User", result.getName());
    }
}