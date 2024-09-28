// src/main/java/com/abhinavmicroservice/projectproposals/model/JwtResponse.java
package com.abhinavmicroservice.projectproposals.model;

import lombok.Getter;

@Getter
public class JwtResponse {
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    // Getter
}