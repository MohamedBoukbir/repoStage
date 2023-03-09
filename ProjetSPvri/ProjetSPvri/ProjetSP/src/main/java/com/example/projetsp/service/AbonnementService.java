package com.example.projetsp.service;


import com.example.projetsp.dao.AbonnementRepository;
import com.example.projetsp.entities.Abonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbonnementService {
    @Autowired
    private AbonnementRepository abonnementRepository;

    public List<Abonnement> listAbonnement(){
        return abonnementRepository.findAll();
    }

    public Abonnement uneAbonnement(int id) {
        Optional<Abonnement> abo = abonnementRepository.findById(id);
        Abonnement abonnement= null;
        if(abo.isPresent())
            abonnement = abo.get();
        return abonnement ;
    }

    public void ajouterAbonnement(Abonnement abonnement) {
        abonnementRepository.save(abonnement);  // insert into article () values()
    }

    public void modifierAbonnement(Abonnement abonnementNouveau) {
        Abonnement abonnementAncien = abonnementRepository.findById(abonnementNouveau.getId()).get();
        abonnementAncien.setDescription(abonnementNouveau.getDescription());
        abonnementAncien.setPrix(abonnementNouveau.getPrix());
        abonnementAncien.setCapacite(abonnementNouveau.getCapacite());
        abonnementAncien.setVilleDepart(abonnementNouveau.getVilleDepart());
        abonnementAncien.setVilleArrive(abonnementNouveau.getVilleArrive());
        abonnementAncien.setDateLimite(abonnementNouveau.getDateLimite());
        abonnementAncien.setHeureDepart(abonnementNouveau.getHeureDepart());
        abonnementAncien.setHeureArrive(abonnementNouveau.getHeureArrive());
        abonnementAncien.setSociete(abonnementNouveau.getSociete());
        abonnementRepository.save(abonnementAncien);
    }

    public void supprimerAbonnement(int id) {
        Optional<Abonnement> abonnementAncien = abonnementRepository.findById(id);
        abonnementRepository.delete(abonnementAncien.get());
    }

}
