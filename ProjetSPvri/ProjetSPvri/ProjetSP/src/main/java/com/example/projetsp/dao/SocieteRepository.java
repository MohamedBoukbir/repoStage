package com.example.projetsp.dao;

import com.example.projetsp.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocieteRepository extends JpaRepository<Societe,Integer> {
}
