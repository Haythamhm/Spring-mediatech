package com.springhayth.mediatech.Dto;

import com.springhayth.mediatech.Annotations.IpAddress;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {

    @Size(min = 5, message = "ce champ doit avoir au moins 5 characteres!")
    @Size(max = 20 ,message = "ce champ ne doit depasser 20 characteres!")
    @NotBlank(message = "Ce champ est vide!")
    private String nom;


    @Size(min = 5, message = "ce champ doit avoir au moins 5 characteres!")
    @Size(max = 20 ,message = "ce champ ne doit depasser 20 characteres!")
    @NotBlank(message = "Ce champ est vide!")
    private String prenom;

    @NotNull
    @Pattern(regexp = "^(\\+212|0)([ \\-_/]*)(\\d[ \\-_/]*){9}$", message = "format invalid!")
    private String telephone;

    @IpAddress()
    private String ip;
}
