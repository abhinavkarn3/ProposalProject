package com.abhinavmicroservice.projectproposals.repository;

import com.abhinavmicroservice.projectproposals.entity.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void findByIdReturnsTaskIfExists() {
        Task task = new Task();
        task.setDescription("Test Task");
        task = taskRepository.save(task);

        Optional<Task> result = taskRepository.findById(task.getId());
        assertTrue(result.isPresent());
        assertEquals("Test Task", result.get().getDescription());
    }

    @Test
    void findByIdReturnsEmptyIfNotExists() {
        Optional<Task> result = taskRepository.findById(1L);
        assertFalse(result.isPresent());
    }

    @Test
    void saveTaskSavesAndReturnsTask() {
        Task task = new Task();
        task.setDescription("Test Task");

        Task result = taskRepository.save(task);
        assertNotNull(result);
        assertEquals("Test Task", result.getDescription());
    }
}