package com.abhinavmicroservice.projectproposals.controller;

import com.abhinavmicroservice.projectproposals.entity.Proposal;
import com.abhinavmicroservice.projectproposals.entity.Task;
import com.abhinavmicroservice.projectproposals.service.ProposalService;
import com.abhinavmicroservice.projectproposals.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing proposals and tasks for coordinators.
 */
@RestController
@RequestMapping("/coordinator")
public class ProposalCoordinatorController {

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private TaskService taskService;

    /**
     * Creates a new proposal.
     *
     * @param proposal the proposal to create
     * @return the created proposal
     */
    @PostMapping("/proposals")
    public Proposal createProposal(@RequestBody Proposal proposal) {
        return proposalService.saveProposal(proposal);
    }

    /**
     * Creates a new task.
     *
     * @param task the task to create
     * @return the created task
     */
    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    /**
     * Retrieves all proposals.
     *
     * @return a list of all proposals
     */
    @GetMapping("/proposals")
    public List<Proposal> getAllProposals() {
        return proposalService.getAllProposals();
    }

    /**
     * Retrieves all tasks.
     *
     * @return a list of all tasks
     */
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
}