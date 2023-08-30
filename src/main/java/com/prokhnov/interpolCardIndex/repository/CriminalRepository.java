package com.prokhnov.interpolCardIndex.repository;

import com.prokhnov.interpolCardIndex.model.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * The {@code CriminalRepository} interface extends {@code JpaRepository}.<br/>
 * Repository of Criminal.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Repository
public interface CriminalRepository extends JpaRepository<Criminal, Long> {
    List<Criminal> findAllByIsArchivedIsTrue();

    List<Criminal> findAllByIsArchivedIsFalse();

    List<Criminal> findCriminalByCriminalGroupId(Long id);

    List<Criminal> findCriminalByCriminalGroupIsNull();

    @Query("SELECT c FROM Criminal c " +
            "WHERE (:firstName IS NULL OR c.firstName LIKE %:firstName%) " +
            "AND (:lastName IS NULL OR c.lastName LIKE %:lastName%) " +
            "AND (:nickname IS NULL OR c.nickname LIKE %:nickname%) " +
            "AND (:nationality IS NULL OR c.nationality LIKE %:nationality%) " +
            "AND (:hairColor IS NULL OR c.hairColor LIKE %:hairColor%) " +
            "AND (:eyeColor IS NULL OR c.eyeColor LIKE %:eyeColor%) " +
            "AND (:distinguishingFeatures IS NULL OR c.distinguishingFeatures LIKE %:distinguishingFeatures%) " +
            "AND (:birthDate IS NULL OR c.birthDate = :birthDate) " +
            "AND (:lastKnownAddress IS NULL OR c.lastKnownAddress LIKE %:lastKnownAddress%) " +
            "AND (:languages IS NULL OR c.languages LIKE %:languages%) " +
            "AND (:criminalProfession IS NULL OR c.criminalProfession LIKE %:criminalProfession%) " +
            "AND (:lastCrimeDetails IS NULL OR c.lastCrimeDetails LIKE %:lastCrimeDetails%) " +
            "AND (:isArchived IS NULL OR c.isArchived = :isArchived) " +
            "AND (:isDead IS NULL OR c.isDead = :isDead) ")
    List<Criminal> findByAttributes(@Param("firstName") String firstName,
                                    @Param("lastName") String lastName,
                                    @Param("nickname") String nickname,
                                    @Param("nationality") String nationality,
                                    @Param("hairColor") String hairColor,
                                    @Param("eyeColor") String eyeColor,
                                    @Param("distinguishingFeatures") String distinguishingFeatures,
                                    @Param("birthDate") LocalDate birthDate,
                                    @Param("lastKnownAddress") String lastKnownAddress,
                                    @Param("languages") String languages,
                                    @Param("criminalProfession") String criminalProfession,
                                    @Param("lastCrimeDetails") String lastCrimeDetails,
                                    @Param("isArchived") Boolean isArchived,
                                    @Param("isDead") Boolean isDead);

}
