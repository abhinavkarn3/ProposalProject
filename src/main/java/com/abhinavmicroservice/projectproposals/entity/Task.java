package com.abhinavmicroservice.projectproposals.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class representing a task.
 */
@Entity
@Getter
@Setter
public class Task {

    /**
     * The unique identifier for the task.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The description of the task.
     */
    private String description;

    /**
     * The skill set required for the task.
     */
    private String skillSet;

    /**
     * The status of the task. Possible values are "Pending", "In Progress", "Completed".
     */
    private String status;

    /**
     * The proposal to which this task belongs.
     */
    @ManyToOne
    @JoinColumn(name = "proposal_id")
    private Proposal proposal;

    /**
     * The user assigned to this task.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}