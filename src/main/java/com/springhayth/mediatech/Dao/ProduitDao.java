package com.springhayth.mediatech.Dao;

import com.springhayth.mediatech.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProduitDao extends JpaRepository<Produit, Integer> {

    Optional<Produit> findByRef(String ref);
    Optional<Produit> findByLibelle(String libelle);
    List<Produit> findByPrixGreaterThan(BigDecimal prix);
    int deleteByRef(String ref);
}
