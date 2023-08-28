package com.prokhnov.interpolCardIndex.dto;

import lombok.*;

import java.time.LocalDate;

/**
 * The {@code CriminalDto} class.<br/>
 * Class that provide DTO for Criminal class.
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
