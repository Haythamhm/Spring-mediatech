package com.springhayth.mediatech.Service;

import com.springhayth.mediatech.Entities.Facture;

import java.util.List;

public interface FactureService {

    Facture saveFacture(Facture facture);
    List<Facture> FindAll();
}
