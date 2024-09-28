package com.abhinavmicroservice.projectproposals.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}