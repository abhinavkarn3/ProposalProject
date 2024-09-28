package com.abhinavmicroservice.projectproposals.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Entity class representing a proposal.
 */
@Entity
@Getter
@Setter
public class Proposal {

    /**
     * The unique identifier for the proposal.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The title of the proposal.
     */
    private String title;

    /**
     * The description of the proposal.
     */
    private String description;

    /**
     * The set of tasks associated with the proposal.
     */
    @OneToMany(mappedBy = "proposal")
    private Set<Task> tasks;
}

