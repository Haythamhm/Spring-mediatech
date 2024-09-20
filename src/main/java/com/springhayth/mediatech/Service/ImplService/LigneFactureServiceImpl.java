package com.springhayth.mediatech.Service.ImplService;

import com.springhayth.mediatech.Dao.LigneFactureDao;
import com.springhayth.mediatech.Entities.LigneFactureEntity;
import com.springhayth.mediatech.Service.LigneFactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LigneFactureServiceImpl implements LigneFactureService {

    private final LigneFactureDao ligneFactureDao;

    @Override
    public LigneFactureEntity saveLigneFacture(LigneFactureEntity ligneFacture) {
        return ligneFactureDao.save(ligneFacture);
    }

    @Override
    public List<LigneFactureEntity> findAll() {
        return ligneFactureDao.findAll();
    }
}
