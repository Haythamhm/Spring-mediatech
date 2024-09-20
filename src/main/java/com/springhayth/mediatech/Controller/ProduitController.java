package com.springhayth.mediatech.Controller;


import com.springhayth.mediatech.Dto.ProduitDto;
import com.springhayth.mediatech.Service.ProduitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;

    @PostMapping("/")
    public ProduitDto save(@Valid @RequestBody ProduitDto produitDto) {
        return produitService.save(produitDto);
    }

    @GetMapping("/ref/{ref}")
    public ProduitDto findByRef(@PathVariable String ref) {
        return produitService.findByRef(ref);
    }

    @GetMapping("/")
    public List<ProduitDto> findAll() {
        return produitService.findAll();
    }

    @PutMapping("/")
    public ProduitDto update(@Valid @RequestBody ProduitDto produitDto) {
        return produitService.update(produitDto);
    }

    @DeleteMapping("/ref/{ref}")
    public int delete(@PathVariable String ref) {
        return produitService.delete(ref);
    }


}
