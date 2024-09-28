package com.abhinavmicroservice.projectproposals.repository;


import com.abhinavmicroservice.projectproposals.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Proposal entities.
 * Extends JpaRepository to provide CRUD operations and more.
 */
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
}
