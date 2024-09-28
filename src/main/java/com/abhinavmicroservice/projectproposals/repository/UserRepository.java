package com.abhinavmicroservice.projectproposals.repository;

import com.abhinavmicroservice.projectproposals.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing User entities.
 * Extends JpaRepository to provide CRUD operations and more.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
}

