package com.example.demo.controller;

import com.example.demo.entities.Company;
import com.example.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) throws Exception {
        Optional<Company> companyOptional = companyService.findCompanyByCode(company.getCodigoCompany());
        if(companyOptional.isPresent()){
            throw new Exception("Ya existe una Company con ese codigo");
        }else{
            return ResponseEntity.ok(companyService.createCompany(company));
        }
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() { return ResponseEntity.ok(companyService.getCompanies()); }

    @GetMapping("/code={code}")
    public ResponseEntity<Company> getCompanyByCode(@PathVariable String code) throws Exception {
        Optional<Company> companyOptional = companyService.findCompanyByCode(code);
        if(companyOptional.isPresent()){
            return ResponseEntity.ok(companyOptional.get());
        }else{
            throw new Exception("No se encontró la company con ese codigo");
        }
    }

    @PutMapping
    public ResponseEntity<String> updateCompany(@RequestBody Company company) throws Exception {
        Optional<Company> companyOptional = companyService.findCompanyById(company.getIdCompany());
        if (companyOptional.isPresent()){
            companyService.updateCompany(company);
            return ResponseEntity.ok("Company actualizada");
        }else{
            throw new Exception("No se encontro la company con ese id");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) throws Exception {
        Optional<Company> companyOptional = companyService.findCompanyById(id);
        if (companyOptional.isPresent()){
            companyService.deleteCompany(id);
            return ResponseEntity.ok("Se eliminó correctamente");
        }else{
            throw new Exception("No se encontró la company a eliminar");
        }
    }

}
