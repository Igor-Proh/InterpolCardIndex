package com.prokhnov.interpolCardIndex.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CriminalDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String nickname;
    private Double height;
    private String hairColor;
    private String eyeColor;
    private String distinguishingFeatures;
    private String nationality;
    private LocalDate birthDate;
    private String lastKnownAddress;
    private String languages;
    private String criminalProfession;
    private String lastCrimeDetails;
    private boolean isArchived;
    private boolean isDead;
    private CriminalGroupDto criminalGroup;
}
