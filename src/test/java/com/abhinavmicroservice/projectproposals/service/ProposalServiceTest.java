package com.abhinavmicroservice.projectproposals.service;

import com.abhinavmicroservice.projectproposals.entity.Proposal;
import com.abhinavmicroservice.projectproposals.repository.ProposalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProposalServiceTest {

    @Mock
    private ProposalRepository proposalRepository;

    @InjectMocks
    private ProposalService proposalService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProposalsReturnsListOfProposals() {
        Proposal proposal = new Proposal();
        proposal.setId(1L);
        proposal.setTitle("Test Proposal");
        List<Proposal> proposals = Collections.singletonList(proposal);

        when(proposalRepository.findAll()).thenReturn(proposals);

        List<Proposal> result = proposalService.getAllProposals();
        assertEquals(1, result.size());
        assertEquals("Test Proposal", result.get(0).getTitle());
    }

    @Test
    void getProposalByIdReturnsProposalIfExists() {
        Proposal proposal = new Proposal();
        proposal.setId(1L);
        proposal.setTitle("Test Proposal");

        when(proposalRepository.findById(1L)).thenReturn(Optional.of(proposal));

        Optional<Proposal> result = proposalService.getProposalById(1L);
        assertNotNull(result);
        assertEquals("Test Proposal", result.getTitle());
    }

    @Test
    void getProposalByIdReturnsNullIfNotExists() {
        when(proposalRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Proposal> result = proposalService.getProposalById(1L);
        assertNull(result);
    }

    @Test
    void saveProposalSavesAndReturnsProposal() {
        Proposal proposal = new Proposal();
        proposal.setId(1L);
        proposal.setTitle("Test Proposal");

        when(proposalRepository.save(proposal)).thenReturn(proposal);

        Proposal result = proposalService.saveProposal(proposal);
        assertNotNull(result);
        assertEquals("Test Proposal", result.getTitle());
    }
}