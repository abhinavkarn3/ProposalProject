package com.abhinavmicroservice.projectproposals.repository;

import com.abhinavmicroservice.projectproposals.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}