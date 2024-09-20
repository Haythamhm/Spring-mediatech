package com.springhayth.mediatech.Dao;

import com.springhayth.mediatech.Entities.LigneFactureEntity;
import com.springhayth.mediatech.Entities.LigneFactureKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneFactureDao extends JpaRepository<LigneFactureEntity, LigneFactureKey> {

}
