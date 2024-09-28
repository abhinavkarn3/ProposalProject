package com.abhinavmicroservice.projectproposals.repository;

import com.abhinavmicroservice.projectproposals.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Task entities.
 * Extends JpaRepository to provide CRUD operations and more.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
}
