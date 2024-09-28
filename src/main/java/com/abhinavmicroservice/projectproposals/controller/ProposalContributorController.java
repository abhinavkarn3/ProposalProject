package com.abhinavmicroservice.projectproposals.controller;

import com.abhinavmicroservice.projectproposals.entity.Task;
import com.abhinavmicroservice.projectproposals.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing tasks for contributors.
 */
@RestController
@RequestMapping("/contributor")
public class ProposalContributorController {

    @Autowired
    private TaskService taskService;

    /**
     * Retrieves all tasks.
     *
     * @return a list of all tasks
     */
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * Accepts a task by setting its status to "In Progress" and assigning a user.
     *
     * @param id the ID of the task to accept
     * @param task the task details including the user
     * @return the updated task
     * @throws ResourceNotFoundException if the task is not found
     */
    @PostMapping("/tasks/{id}/accept")
    public Task acceptTask(@PathVariable Long id, @RequestBody Task task) {
        Task existingTask = taskService.getTaskById(id);
        if (existingTask == null) {
            throw new ResourceNotFoundException("Task not found with id " + id);
        }
        existingTask.setStatus("In Progress");
        existingTask.setUser(task.getUser());
        return taskService.saveTask(existingTask);
    }

    /**
     * Completes a task by setting its status to "Completed".
     *
     * @param id the ID of the task to complete
     * @return the updated task
     * @throws ResourceNotFoundException if the task is not found
     */
    @PostMapping("/tasks/{id}/complete")
    public Task completeTask(@PathVariable Long id) {
        Task existingTask = taskService.getTaskById(id);
        if (existingTask == null) {
            throw new ResourceNotFoundException("Task not found with id " + id);
        }
        existingTask.setStatus("Completed");
        return taskService.saveTask(existingTask);
    }
}
