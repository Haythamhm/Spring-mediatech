package com.springhayth.mediatech.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProduitDto {

    @NotBlank
    private String ref;

    @NotBlank
    private String libelle;

    @NotNull
    private BigDecimal prix;

    @NotNull
    private long quantite_stock;

}
