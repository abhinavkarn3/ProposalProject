package com.abhinavmicroservice.projectproposals.controller;

import com.abhinavmicroservice.projectproposals.entity.Proposal;
import com.abhinavmicroservice.projectproposals.entity.Task;
import com.abhinavmicroservice.projectproposals.service.ProposalService;
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

public class ProposalCoordinatorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProposalService proposalService;

    @Mock
    private TaskService taskService;

    @InjectMocks
    private ProposalCoordinatorController proposalCoordinatorController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(proposalCoordinatorController).build();
    }

    @Test
    void createProposalReturnsCreatedProposal() throws Exception {
        Proposal proposal = new Proposal();
        proposal.setId(1L);
        proposal.setTitle("New Proposal");

        when(proposalService.saveProposal(any(Proposal.class))).thenReturn(proposal);

        mockMvc.perform(post("/coordinator/proposals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"New Proposal\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("New Proposal"));

        verify(proposalService, times(1)).saveProposal(any(Proposal.class));
    }

    @Test
    void createTaskReturnsCreatedTask() throws Exception {
        Task task = new Task();
        task.setId(1L);
        task.setDescription("New Task");

        when(taskService.saveTask(any(Task.class))).thenReturn(task);

        mockMvc.perform(post("/coordinator/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"description\": \"New Task\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.description").value("New Task"));

        verify(taskService, times(1)).saveTask(any(Task.class));
    }

    @Test
    void getAllProposalsReturnsListOfProposals() throws Exception {
        Proposal proposal = new Proposal();
        proposal.setId(1L);
        proposal.setTitle("Test Proposal");
        List<Proposal> proposals = Collections.singletonList(proposal);

        when(proposalService.getAllProposals()).thenReturn(proposals);

        mockMvc.perform(get("/coordinator/proposals"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].title").value("Test Proposal"));

        verify(proposalService, times(1)).getAllProposals();
    }

    @Test
    void getAllTasksReturnsListOfTasks() throws Exception {
        Task task = new Task();
        task.setId(1L);
        task.setDescription("Test Task");
        List<Task> tasks = Collections.singletonList(task);

        when(taskService.getAllTasks()).thenReturn(tasks);

        mockMvc.perform(get("/coordinator/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].description").value("Test Task"));

        verify(taskService, times(1)).getAllTasks();
    }
}