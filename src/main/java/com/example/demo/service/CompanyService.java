package com.example.demo.service;

import com.example.demo.entities.Company;
import com.example.demo.service.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company createCompany(Company company){ return companyRepository.save(company); }

    public void updateCompany(Company company){ companyRepository.save(company); }

    public List<Company> getCompanies(){ return companyRepository.findAll(); }

    public void deleteCompany(Long id) { companyRepository.deleteById(id); }

    public Optional<Company> findCompanyById(Long id) { return companyRepository.findById(id); }

    public Optional<Company> findCompanyByCode( String code ) {return companyRepository.findByCodigoCompany(code); }

}
