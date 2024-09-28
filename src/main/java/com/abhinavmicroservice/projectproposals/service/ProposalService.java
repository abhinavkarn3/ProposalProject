package com.abhinavmicroservice.projectproposals.service;

import com.abhinavmicroservice.projectproposals.entity.Proposal;
import com.abhinavmicroservice.projectproposals.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProposalService {
    @Autowired
    private ProposalRepository proposalRepository;

    public List<Proposal> getAllProposals() {
        return proposalRepository.findAll();
    }

    public Optional<Proposal> getProposalById(Long id) {
        return proposalRepository.findById(id);
    }

    public Proposal saveProposal(Proposal proposal) {
        return proposalRepository.save(proposal);
    }
}
