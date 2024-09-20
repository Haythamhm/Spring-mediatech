package com.springhayth.mediatech.Service.ImplService;

import com.springhayth.mediatech.Dao.FactureDao;
import com.springhayth.mediatech.Entities.Facture;
import com.springhayth.mediatech.Service.FactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements FactureService {

    private final FactureDao factureDao;

    @Override
    public Facture saveFacture(Facture facture) {
        return factureDao.save(facture);
    }

    @Override
    public List<Facture> FindAll() {
        return factureDao.findAll();
    }
}
