package com.springhayth.mediatech.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduit;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private String ref;

    @Column(nullable = false)
    private BigDecimal prix;

    @Column(nullable = false)
    private double quantite_stock;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LigneFactureEntity> factureEntities;

}
