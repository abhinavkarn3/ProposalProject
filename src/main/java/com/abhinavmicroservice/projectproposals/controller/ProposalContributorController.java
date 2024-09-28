package com.abhinavmicroservice.projectproposals.controller;

import com.abhinavmicroservice.projectproposals.entity.Task;
import com.abhinavmicroservice.projectproposals.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contributor")
public class ProposalContributorController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/tasks/{id}/accept")
    public Task acceptTask(@PathVariable Long id, @RequestBody Task task) {
        Task existingTask = taskService.getTaskById(id);
        if (existingTask != null) {
            existingTask.setStatus("In Progress");
            existingTask.setUser(task.getUser());
            return taskService.saveTask(existingTask);
        }
        return null;
    }

    @PostMapping("/tasks/{id}/complete")
    public Task completeTask(@PathVariable Long id) {
        Task existingTask = taskService.getTaskById(id);
        if (existingTask != null) {
            existingTask.setStatus("Completed");
            return taskService.saveTask(existingTask);
        }
        return null;
    }
}
