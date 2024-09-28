package com.abhinavmicroservice.projectproposals.repository;

import com.abhinavmicroservice.projectproposals.entity.Proposal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProposalRepositoryTest {

    @Autowired
    private ProposalRepository proposalRepository;

    @Test
    void findByIdReturnsProposalIfExists() {
        Proposal proposal = new Proposal();
        proposal.setTitle("Test Proposal");
        proposal = proposalRepository.save(proposal);

        Optional<Proposal> result = proposalRepository.findById(proposal.getId());
        assertTrue(result.isPresent());
        assertEquals("Test Proposal", result.get().getTitle());
    }

    @Test
    void findByIdReturnsEmptyIfNotExists() {
        Optional<Proposal> result = proposalRepository.findById(1L);
        assertFalse(result.isPresent());
    }

    @Test
    void saveProposalSavesAndReturnsProposal() {
        Proposal proposal = new Proposal();
        proposal.setTitle("Test Proposal");

        Proposal result = proposalRepository.save(proposal);
        assertNotNull(result);
        assertEquals("Test Proposal", result.getTitle());
    }
}