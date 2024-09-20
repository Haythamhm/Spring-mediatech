package com.springhayth.mediatech.Service;

import com.springhayth.mediatech.Entities.LigneFactureEntity;

import java.util.List;

public interface LigneFactureService {

    LigneFactureEntity saveLigneFacture(LigneFactureEntity ligneFacture);
    List<LigneFactureEntity> findAll();
}
