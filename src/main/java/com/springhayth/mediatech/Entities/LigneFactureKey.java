package com.springhayth.mediatech.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class LigneFactureKey implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "facture_id")
    private int factureId;

    @Column(name = "produit_id")
    private int produitId;



}
