package com.springhayth.mediatech.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleEntity implements Serializable {

    @Id
    private int roleId;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns =@JoinColumn(name = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<UserEntity> users;
}
