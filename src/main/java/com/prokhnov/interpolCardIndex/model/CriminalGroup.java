package com.prokhnov.interpolCardIndex.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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
