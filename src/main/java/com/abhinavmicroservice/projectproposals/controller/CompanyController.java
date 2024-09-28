package com.abhinavmicroservice.projectproposals.controller;


import com.abhinavmicroservice.projectproposals.entity.Company;
import com.abhinavmicroservice.projectproposals.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }
}
