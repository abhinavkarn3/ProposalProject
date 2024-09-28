package com.abhinavmicroservice.projectproposals.service;

import com.abhinavmicroservice.projectproposals.entity.Task;
import com.abhinavmicroservice.projectproposals.repository.TaskRepository;
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

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllTasksReturnsListOfTasks() {
        Task task = new Task();
        task.setId(1L);
        task.setDescription("Test Task");
        List<Task> tasks = Collections.singletonList(task);

        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAllTasks();
        assertEquals(1, result.size());
        assertEquals("Test Task", result.get(0).getDescription());
    }

    @Test
    void getTaskByIdReturnsTaskIfExists() {
        Task task = new Task();
        task.setId(1L);
        task.setDescription("Test Task");

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Task result = taskService.getTaskById(1L);
        assertNotNull(result);
        assertEquals("Test Task", result.getDescription());
    }

    @Test
    void getTaskByIdReturnsNullIfNotExists() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        Task result = taskService.getTaskById(1L);
        assertNull(result);
    }

    @Test
    void saveTaskSavesAndReturnsTask() {
        Task task = new Task();
        task.setId(1L);
        task.setDescription("Test Task");

        when(taskRepository.save(task)).thenReturn(task);

        Task result = taskService.saveTask(task);
        assertNotNull(result);
        assertEquals("Test Task", result.getDescription());
    }
}