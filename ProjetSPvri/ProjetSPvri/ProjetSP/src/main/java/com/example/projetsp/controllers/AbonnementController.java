package com.example.projetsp.controllers;


import com.example.projetsp.entities.Abonnement;
import com.example.projetsp.entities.Client;
import com.example.projetsp.entities.Societe;
import com.example.projetsp.service.AbonnementService;
import com.example.projetsp.service.ClientService;
import com.example.projetsp.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AbonnementController {

    @Autowired
    private AbonnementService abonnementService;
    @Autowired
    private SocieteService societeService;
    @Autowired
    private ClientService clientService;
    @GetMapping("/home")
    public String getHome(Model model,Model model2) {
        List<Societe> societes = societeService.listSociete();
        List<Abonnement> abonnements = abonnementService.listAbonnement();
        List<Client> clients = clientService.listClient();
        model.addAttribute("abonnements", abonnements);
        model.addAttribute("societes", societes);
        model.addAttribute("clients", clients);
//        return "abonnement/listeabonnement";

        return "home/home";
    }

    @GetMapping("/login")
    public String loginForm() {

        return "login";
    }


    @GetMapping("/abonnements")
    public String getArts(Model model) {
        List<Abonnement> abonnements = abonnementService.listAbonnement();
        List<Societe> societes = societeService.listSociete();
        model.addAttribute("abonnements", abonnements); /////
        model.addAttribute("societes", societes); /////
        return "abonnement/listeabonnement";
    }


    @RequestMapping("/addabonnement")
    public String ajouterAbonnement(Model model) {
        Abonnement abonnement = new Abonnement();
        List<Societe> societes = societeService.listSociete();
        model.addAttribute("abonnement", abonnement);
        model.addAttribute("societes", societes);
        System.out.println("----------- ici  addArt -------------");
        return "abonnement/ajouterabonnement";
    }

    @PostMapping("/PostAddabonnement")
    public String postAjouterAbonnement(
            @ModelAttribute("abonnement")Abonnement abonnement,
            BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            // retour au meme formulaire
            return "abonnement/ajouterabonnement";
        }
        // sinon, il fait son traitement qui est l'ajout
        abonnementService.ajouterAbonnement(abonnement);
        return "redirect:/abonnements";
    }
    @GetMapping("/deleteabonnement/{id}")
    public String supprimerAbonnement(@PathVariable(value="id")int id) {
        abonnementService.supprimerAbonnement(id);
        return "redirect:/abonnements";
    }

    @GetMapping("/editabonnement/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Abonnement abonnement = abonnementService.uneAbonnement(id);
        model.addAttribute("abonnement", abonnement);
        return "abonnement/modifierabonnement";
    }

    @PostMapping("/updateabonnement/{id}")
    public String updateUser(@PathVariable("id") int id,Abonnement abonnement,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            abonnement.setId(id);
            return "abonnement/modifierabonnement";
        }

        abonnementService.modifierAbonnement(abonnement);
        return "redirect:/abonnements";
    }

}

