package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "company")
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompany;
    @Column
    private String codigoCompany;
    @Column
    private String nameCompany;
    @Column
    private String descriptionCompany;

    public Company() {
    }

    public Company(String codigoCompany, String nameCompany, String descriptionCompany) {
        this.codigoCompany = codigoCompany;
        this.nameCompany = nameCompany;
        this.descriptionCompany = descriptionCompany;
    }

    public Company(Long idCompany, String codigoCompany, String nameCompany, String descriptionCompany) {
        this.idCompany = idCompany;
        this.codigoCompany = codigoCompany;
        this.nameCompany = nameCompany;
        this.descriptionCompany = descriptionCompany;
    }
}


