package com.abhinavmicroservice.projectproposals.service;

import com.abhinavmicroservice.projectproposals.entity.Proposal;
import com.abhinavmicroservice.projectproposals.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalService {
    @Autowired
    private ProposalRepository proposalRepository;

    public List<Proposal> getAllProposals() {
        return proposalRepository.findAll();
    }

    public Proposal getProposalById(Long id) {
        return proposalRepository.findById(id).orElse(null);
    }

    public Proposal saveProposal(Proposal proposal) {
        return proposalRepository.save(proposal);
    }
}
