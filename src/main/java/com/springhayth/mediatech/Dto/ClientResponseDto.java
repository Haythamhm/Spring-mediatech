package com.springhayth.mediatech.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {

    private int id;
    private String nom;
    private String prenom;
    private String telephone;
}
