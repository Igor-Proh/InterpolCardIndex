package com.prokhnov.interpolCardIndex.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "criminal")
public class Criminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "criminal_id")
    private Long id;

    @Column(name = "criminal_first_name")
    private String firstName;

    @Column(name = "criminal_last_name")
    private String lastName;

    @Column(name = "criminal_nickname")
    private String nickname;

    @Column(name = "criminal_height")
    private Double height;

    @Column(name = "criminal_hair_color")
    private String hairColor;

    @Column(name = "criminal_eye_color")
    private String eyeColor;

    @Column(name = "criminal_distinguishing_features")
    private String distinguishingFeatures;

    @Column(name = "criminal_nationality")
    private String nationality;

    @Column(name = "criminal_birth_date")
    private LocalDate birthDate;

    @Column(name = "criminal_last_known_address")
    private String lastKnownAddress;

    @Column(name = "criminal_languages")
    private String languages;

    @Column(name = "criminal_criminal_profession")
    private String criminalProfession;

    @Column(name = "criminal_last_crime_details")
    private String lastCrimeDetails;

    @Column(name = "criminal_is_archived")
    private boolean isArchived;

    @Column(name = "criminal_is_dead")
    private boolean isDead;

    @ManyToOne
    @JoinColumn(name = "criminal_group_id")
    private CriminalGroup criminalGroup;

}
