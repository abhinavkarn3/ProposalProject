package com.abhinavmicroservice.projectproposals.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class representing a user.
 */
@Entity
@Getter
@Setter
public class User {

    /**
     * The unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    /**
     * The name of the user.
     */
    private String name;

    /**
     * The role of the user. Possible values are "Coordinator" or "Contributor".
     */
    private String role;

    /**
     * The skills of the user.
     */
    private String skills;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}