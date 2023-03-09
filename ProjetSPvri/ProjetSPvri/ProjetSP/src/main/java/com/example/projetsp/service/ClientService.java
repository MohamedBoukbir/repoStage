package com.example.projetsp.service;
import com.example.projetsp.dao.ClientRepository;
import com.example.projetsp.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> listClient(){
        return clientRepository.findAll();
    }

    public Client uneClient(int id) {
        Optional<Client> cte = clientRepository.findById(id);
        Client client= null;
        if(cte.isPresent())
            client = cte.get();
        return client ;
    }
    public void ajouterClient(Client client) {
        clientRepository.save(client);  // insert into article () values()
    }
    public void modifierClient(Client clientNouveau) {
        Client clientAncien = clientRepository.findById(clientNouveau.getId()).get();
        clientAncien.setNom(clientNouveau.getNom());
        clientAncien.setPrenom(clientNouveau.getPrenom());
        clientAncien.setTelephone(clientNouveau.getTelephone());
        clientAncien.setEmail(clientNouveau.getEmail());
        clientAncien.setAdresse(clientNouveau.getAdresse());
        clientRepository.save(clientAncien);
    }

    public void supprimerClient(int id) {
        Optional<Client> clientAncien = clientRepository.findById(id);
        clientRepository.delete(clientAncien.get());
    }

}
