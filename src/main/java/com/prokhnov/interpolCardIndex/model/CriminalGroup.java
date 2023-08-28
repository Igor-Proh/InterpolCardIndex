package com.prokhnov.interpolCardIndex.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * The {@code CriminalGroup} class.<br/>
 * The CriminalGroup Entity class used to work with the database.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "criminal_group")
public class CriminalGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "criminal_group_id")
    private Long id;

    @Column(name = "criminal_group_group_name")
    private String groupName;

    @Column(name = "criminal_group_leader_name")
    private String leaderName;

    @Column(name = "criminal_group_activities")
    private String activities;

    @Column(name = "criminal_group_is_mafia")
    private boolean isMafia;

    @OneToMany(mappedBy = "criminalGroup")
    private Set<Criminal> members;
}
