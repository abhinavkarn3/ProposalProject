package com.abhinavmicroservice.projectproposals.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void userGettersAndSettersWorkCorrectly() {
        User user = new User();
        user.setId(1L);
        user.setName("Test User");

        assertEquals(1L, user.getId());
        assertEquals("Test User", user.getName());
    }

    @Test
    void userHandlesNullName() {
        User user = new User();
        user.setName(null);

        assertNull(user.getName());
    }

    @Test
    void userHandlesEmptyName() {
        User user = new User();
        user.setName("");

        assertEquals("", user.getName());
    }
}