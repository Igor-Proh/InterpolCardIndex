package com.prokhnov.interpolCardIndex.repository;

import com.prokhnov.interpolCardIndex.model.CriminalGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The {@code CriminalGroupRepository} interface extends {@code JpaRepository}.<br/>
 * Repository of CriminalGroup.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Repository
public interface CriminalGroupRepository extends JpaRepository<CriminalGroup, Long> {
    @Query("SELECT c FROM CriminalGroup c " +
            "WHERE (:groupName IS NULL OR c.groupName LIKE %:groupName%) " +
            "AND (:leaderName IS NULL OR c.leaderName LIKE %:leaderName%) " +
            "AND (:activities IS NULL OR c.activities LIKE %:activities%) " +
            "AND (:isMafia IS NULL OR c.isMafia = :isMafia) ")
    List<CriminalGroup> findByAttributes(@Param("groupName") String groupName,
                                         @Param("leaderName") String leaderName,
                                         @Param("activities") String activities,
                                         @Param("isMafia") Boolean isMafia);
}
