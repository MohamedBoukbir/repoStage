package com.example.projetsp.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Societe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // CLE PRIMAIRE DE TABLE
    private String nom;
    private String telephone;
    private String adresse;
    private String email;
    private String siteweb;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getSiteweb() {
        return siteweb;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }
}