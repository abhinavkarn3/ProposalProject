package com.abhinavmicroservice.projectproposals.controller;

import com.abhinavmicroservice.projectproposals.entity.Task;
import com.abhinavmicroservice.projectproposals.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProposalContributorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TaskService taskService;

    @InjectMocks
    private ProposalContributorController proposalContributorController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(proposalContributorController).build();
    }

    @Test
    void getAllTasksReturnsListOfTasks() throws Exception {
        Task task = new Task();
        task.setId(1L);
        task.setDescription("Test Task");
        List<Task> tasks = Collections.singletonList(task);

        when(taskService.getAllTasks()).thenReturn(tasks);

        mockMvc.perform(get("/contributor/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].description").value("Test Task"));

        verify(taskService, times(1)).getAllTasks();
    }

    @Test
    void acceptTaskUpdatesTaskStatusAndAssignsUser() throws Exception {
        Task task = new Task();
        task.setId(1L);
        task.setStatus("Pending");

        Task updatedTask = new Task();
        updatedTask.setId(1L);
        updatedTask.setStatus("In Progress");

        when(taskService.getTaskById(1L)).thenReturn(task);
        when(taskService.saveTask(any(Task.class))).thenReturn(updatedTask);

        mockMvc.perform(post("/contributor/tasks/1/accept")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"user\": {\"id\": 1}}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("In Progress"));

        verify(taskService, times(1)).getTaskById(1L);
        verify(taskService, times(1)).saveTask(any(Task.class));
    }

    @Test
    void acceptTaskReturnsNullIfTaskDoesNotExist() throws Exception {
        when(taskService.getTaskById(1L)).thenReturn(null);

        mockMvc.perform(post("/contributor/tasks/1/accept")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"user\": {\"id\": 1}}"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(taskService, times(1)).getTaskById(1L);
        verify(taskService, never()).saveTask(any(Task.class));
    }

    @Test
    void completeTaskUpdatesTaskStatusToCompleted() throws Exception {
        Task task = new Task();
        task.setId(1L);
        task.setStatus("In Progress");

        Task updatedTask = new Task();
        updatedTask.setId(1L);
        updatedTask.setStatus("Completed");

        when(taskService.getTaskById(1L)).thenReturn(task);
        when(taskService.saveTask(any(Task.class))).thenReturn(updatedTask);

        mockMvc.perform(post("/contributor/tasks/1/complete"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("Completed"));

        verify(taskService, times(1)).getTaskById(1L);
        verify(taskService, times(1)).saveTask(any(Task.class));
    }

    @Test
    void completeTaskReturnsNullIfTaskDoesNotExist() throws Exception {
        when(taskService.getTaskById(1L)).thenReturn(null);

        mockMvc.perform(post("/contributor/tasks/1/complete"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(taskService, times(1)).getTaskById(1L);
        verify(taskService, never()).saveTask(any(Task.class));
    }
}