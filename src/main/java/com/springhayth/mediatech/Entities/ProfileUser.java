package com.springhayth.mediatech.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Table(name = "profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileUser implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String avatar;

    private String telephone;

    @OneToOne
    @JoinColumn(name="user_id")
    private UserEntity user;
}
