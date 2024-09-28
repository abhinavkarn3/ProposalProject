package com.abhinavmicroservice.projectproposals.repository;


import com.abhinavmicroservice.projectproposals.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    Optional<Proposal> findById(Long id);
}
