package com.springhayth.mediatech.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "ligne_facture")
@Data
@ToString
public class LigneFactureEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private LigneFactureKey id;

    @ManyToOne()
    @MapsId("factureId")
    @JoinColumn(name = "facture_id")
    private Facture facture;

    @ManyToOne()
    @MapsId("produitId")
    @JoinColumn(name = "produit_id")
    private Produit produit;

    private double quantite;

}
