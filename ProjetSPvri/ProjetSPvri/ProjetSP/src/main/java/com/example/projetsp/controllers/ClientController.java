package com.example.projetsp.controllers;

import com.example.projetsp.entities.Client;
import com.example.projetsp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/clients")
    public String getClient(Model model) {
        List<Client> clients = clientService.listClient();
        model.addAttribute("clients", clients); /////
        return "client/listeclient";
    }
    @RequestMapping("/addclient")
    public String ajouterClient(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);

        return "client/ajouterclient";
    }

    @PostMapping("/PostAddclient")
    public String postAjouterClient(
            @ModelAttribute("client")Client client,
            BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            // retour au meme formulaire
            return "client/ajouterclient";
        }
        // sinon, il fait son traitement qui est l'ajout
        clientService.ajouterClient(client);
        return "redirect:/clients";
    }
    @GetMapping("/deleteclient/{id}")
    public String supprimerClient(@PathVariable(value="id")int id) {
        clientService.supprimerClient(id);
        return "redirect:/clients";
    }
    @GetMapping("/editclient/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Client client = clientService.uneClient(id);
        model.addAttribute("client", client);
        return "client/modifierclient";
    }

    @PostMapping("/updateclient/{id}")
    public String updateUser(@PathVariable("id") int id,Client client,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            client.setId(id);
            return "client/modifierclient";
        }

        clientService.modifierClient(client);
        return "redirect:/clients";
    }
}
