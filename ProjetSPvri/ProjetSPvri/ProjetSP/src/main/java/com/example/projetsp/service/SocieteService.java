package com.example.projetsp.service;
import com.example.projetsp.dao.AbonnementRepository;
import com.example.projetsp.dao.SocieteRepository;
import com.example.projetsp.entities.Abonnement;
import com.example.projetsp.entities.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocieteService {

        @Autowired
        private SocieteRepository societeRepository;
        @Autowired
        private AbonnementRepository abonnementRepository;

        public List<Societe> listSociete(){
            return societeRepository.findAll();
        }

        public Societe uneSociete(int id) {
            Optional<Societe> ste = societeRepository.findById(id);
            Societe societe= null;
            if(ste.isPresent())
                societe = ste.get();
            return societe ;
        }

        public void ajouterSociete(Societe societe) {
            societeRepository.save(societe);  // insert into article () values()
        }

        public void modifier(Societe societeNouveau) {
            Societe societeAncien = societeRepository.findById(societeNouveau.getId()).get();
            societeAncien.setNom(societeNouveau.getNom());
            societeAncien.setAdresse(societeNouveau.getAdresse());
            societeAncien.setTelephone(societeNouveau.getTelephone());
            societeAncien.setEmail(societeNouveau.getEmail());
            societeAncien.setSiteweb(societeNouveau.getSiteweb());
            societeRepository.save(societeAncien);
        }



    // Update operation

        public void supprimerSocite(int id) {
            Optional<Societe> societeAncien = societeRepository.findById(id);
            societeRepository.delete(societeAncien.get());
        }


    public List<Abonnement> getAbonnementsBySocieteId(int societeId){
        return abonnementRepository.findBySocieteId(societeId);
    }

    }


