package com.example.projetsp.dao;

import com.example.projetsp.entities.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbonnementRepository  extends JpaRepository<Abonnement,Integer> {
    List<Abonnement> findByCapacite(int capacite);
    List<Abonnement> findBySocieteId(int capacite);
}
