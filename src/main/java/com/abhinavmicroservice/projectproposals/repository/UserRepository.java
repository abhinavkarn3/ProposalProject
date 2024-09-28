package com.abhinavmicroservice.projectproposals.repository;


import com.abhinavmicroservice.projectproposals.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
