package com.abhinavmicroservice.projectproposals.repository;


import com.abhinavmicroservice.projectproposals.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
}
