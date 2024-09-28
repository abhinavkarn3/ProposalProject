package com.abhinavmicroservice.projectproposals.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    void taskGettersAndSettersWorkCorrectly() {
        Task task = new Task();
        task.setId(1L);
        task.setDescription("Test Task");
        task.setStatus("Pending");

        assertEquals(1L, task.getId());
        assertEquals("Test Task", task.getDescription());
        assertEquals("Pending", task.getStatus());
    }

    @Test
    void taskHandlesNullDescription() {
        Task task = new Task();
        task.setDescription(null);

        assertNull(task.getDescription());
    }

    @Test
    void taskHandlesEmptyDescription() {
        Task task = new Task();
        task.setDescription("");

        assertEquals("", task.getDescription());
    }

    @Test
    void taskHandlesNullStatus() {
        Task task = new Task();
        task.setStatus(null);

        assertNull(task.getStatus());
    }

    @Test
    void taskHandlesEmptyStatus() {
        Task task = new Task();
        task.setStatus("");

        assertEquals("", task.getStatus());
    }
}