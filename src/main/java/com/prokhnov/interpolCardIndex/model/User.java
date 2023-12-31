package com.prokhnov.interpolCardIndex.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * The {@code User} class.<br/>
 * The User Entity class used to work with the database.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_entity")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password")
    private String password;


    @Column(name = "enabled")
    private boolean enabled;

    @Column(name="username", unique = true)
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles;
}
