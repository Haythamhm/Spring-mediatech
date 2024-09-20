package com.springhayth.mediatech.Dao;

import com.springhayth.mediatech.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureDao extends JpaRepository<Facture, Integer> {

}
