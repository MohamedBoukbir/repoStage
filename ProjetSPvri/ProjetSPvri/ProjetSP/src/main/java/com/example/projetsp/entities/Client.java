package com.example.projetsp.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "client") // modifier le nom du table sur La BD
public class Client {
    @Id //Cle primaire de table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment de cle primaire
    private int id;
    @Column(name = "nom") // modifier le nom du column sur La BD
    private String nom;
    private String prenom;
    @Column(nullable = false) // valuer null non accepté
    private String email;
    @Column(length = 20) // longeur de champs est 20
    private String telephone;
    private String adresse;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Abonnement> abonnementList;

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Abonnement> getAbonnementList() {
        return abonnementList;
    }

    public void setAbonnementList(List<Abonnement> abonnementList) {
        this.abonnementList = abonnementList;
    }
}
