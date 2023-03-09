package com.example.projetsp.controllers;

import com.example.projetsp.entities.Abonnement;
import com.example.projetsp.entities.Societe;
import com.example.projetsp.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
public class SocieteController {
    @Autowired
    private SocieteService societeService;
//    @Autowired
//    private AbonnementService abonnementService;
//    @GetMapping("/home")
//    public String getHome() {
//        System.out.println("------------ Ici Home ----------------------- ");
//        return "home";
//    }

    @GetMapping("/societes")
    public String getSocietes(Model model) {
        List<Societe> societes = societeService.listSociete();
        model.addAttribute("societes", societes); /////
        return "societe/listesocietes";
    }

    @RequestMapping("/addsociete")
    public String ajouterSociete(Model model) {
        Societe societe = new Societe();
        model.addAttribute("societe", societe);

        return "societe/ajoutersociete";
    }

    @PostMapping("/PostAddsociete")
    public String postAjouterSociete(/*indiquer au Spring de lancer la verification*/
        //            @Valid
            @ModelAttribute("societe")Societe societe,
            /*ajouter ce parametre qui detient les erreurs*/
            BindingResult bindingResult) {
            // si l'une des contraintes n'est pas respectées : bindingResult.hasErrors() retourne true
            if(bindingResult.hasErrors()) {
                // retour au meme formulaire
                return "societe/ajoutersociete";
            }
        // sinon, il fait son traitement qui est l'ajout
        societeService.ajouterSociete(societe);
        return "redirect:/societes";
    }

    @GetMapping("/deletesociete/{id}")
    public String supprimerSociete(@PathVariable(value="id")int id) {
        societeService.supprimerSocite(id);
        return "redirect:/societes";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Societe societe = societeService.uneSociete(id);
        model.addAttribute("societe", societe);
        return "societe/modifiersociete";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id,Societe societe,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            societe.setId(id);
            return "societe/modifiersociete";
        }

        societeService.modifier(societe);
        return "redirect:/societes";
    }



    @RequestMapping("/societes-abonnements/{id}")
    public String getAbonemmentsOfSociete(@PathVariable("id") int id, Model model) {
        List<Abonnement> abonnements ;
        abonnements = societeService.getAbonnementsBySocieteId(id);
        model.addAttribute("abonnements", abonnements);

        return "abonnement/listeabonnement";
    }

}



