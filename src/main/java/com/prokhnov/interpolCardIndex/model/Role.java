package com.prokhnov.interpolCardIndex.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * The {@code Role} class.<br/>
 * The Role Entity class used to work with the database.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique=true)
    private String role;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> user;

}
