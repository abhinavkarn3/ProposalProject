package com.abhinavmicroservice.projectproposals.repository;


import com.abhinavmicroservice.projectproposals.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
