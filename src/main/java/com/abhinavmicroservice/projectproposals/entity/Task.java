package com.abhinavmicroservice.projectproposals.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String skillSet;
    private String status; // "Pending", "In Progress", "Completed"

    @ManyToOne
    @JoinColumn(name = "proposal_id")
    private Proposal proposal;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
