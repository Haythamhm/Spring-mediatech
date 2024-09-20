package com.springhayth.mediatech.Dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class FactureDto {

    private String ref;
    private String cin;

    List<LigneFactureDto> ligneFactureDtos;
}
