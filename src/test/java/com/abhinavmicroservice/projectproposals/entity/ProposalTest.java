package com.abhinavmicroservice.projectproposals.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProposalTest {

    @Test
    void proposalGettersAndSettersWorkCorrectly() {
        Proposal proposal = new Proposal();
        proposal.setId(1L);
        proposal.setTitle("Test Proposal");

        assertEquals(1L, proposal.getId());
        assertEquals("Test Proposal", proposal.getTitle());
    }

    @Test
    void proposalHandlesNullTitle() {
        Proposal proposal = new Proposal();
        proposal.setTitle(null);

        assertNull(proposal.getTitle());
    }

    @Test
    void proposalHandlesEmptyTitle() {
        Proposal proposal = new Proposal();
        proposal.setTitle("");

        assertEquals("", proposal.getTitle());
    }
}