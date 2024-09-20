package com.springhayth.mediatech.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factures")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Facture implements Serializable {

    @Id
    private int idFacture;
    @Column(nullable = false)
    private String ref;

    @Column(nullable = false, name = "date_creation_facture")
    private Date dateFacture;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<LigneFactureEntity> factureEntities;

}
