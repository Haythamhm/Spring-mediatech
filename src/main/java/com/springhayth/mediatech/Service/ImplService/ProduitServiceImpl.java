package com.springhayth.mediatech.Service.ImplService;

import com.springhayth.mediatech.Dao.ProduitDao;
import com.springhayth.mediatech.Dto.ProduitDto;
import com.springhayth.mediatech.Entities.Produit;
import com.springhayth.mediatech.Service.ProduitService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProduitServiceImpl implements ProduitService {

    private final ProduitDao produitDao;
    private final ModelMapper modelMapper;

    @Override
    public ProduitDto save(ProduitDto produitDto) {
        if (findByRef(produitDto.getRef())!=null) return null;

        Produit produit = modelMapper.map(produitDto, Produit.class);

        Produit saveProduit = produitDao.save(produit);
        return modelMapper.map(saveProduit, ProduitDto.class);
    }

    @Transactional
    @Override
    public int delete(String ref) {
        return produitDao.deleteByRef(ref);
    }

    @Override
    public ProduitDto update(ProduitDto produitDto) {
        Optional<Produit> produit = produitDao.findByRef(produitDto.getRef());
        if (produit.isEmpty()) return null;
        updateProduit(produit.get(), produitDto);
        Produit updatedProduit = produitDao.save(produit.get());
        return modelMapper.map(updatedProduit, ProduitDto.class);
    }

    private void updateProduit(Produit produit, ProduitDto produitDto) {
        produit.setLibelle(produitDto.getLibelle());
        produit.setPrix(produitDto.getPrix());
        produit.setQuantite_stock(produitDto.getQuantite_stock());
    }

    @Override
    public ProduitDto findByRef(String ref) {
        Produit produit = produitDao.findByRef(ref).orElse(null);
        if(produit==null) return null;
        return modelMapper.map(produit, ProduitDto.class);
    }

    @Override
    public List<ProduitDto> findAll() {
        return produitDao.findAll().stream().map(element->modelMapper.map(element, ProduitDto.class)).collect(Collectors.toList());
    }
}
