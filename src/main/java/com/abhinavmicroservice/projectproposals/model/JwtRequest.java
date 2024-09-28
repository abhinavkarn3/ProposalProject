// src/main/java/com/abhinavmicroservice/projectproposals/model/JwtRequest.java
package com.abhinavmicroservice.projectproposals.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {
    private String email;
    private String password;

    // Getters and setters
}