package com.springhayth.mediatech.Dao;

import com.springhayth.mediatech.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {
    Client findByNom(String nom);
}
