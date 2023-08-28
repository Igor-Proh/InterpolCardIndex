package com.prokhnov.interpolCardIndex.repository;

import com.prokhnov.interpolCardIndex.model.CriminalGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The {@code CriminalGroupRepository} interface extends {@code JpaRepository}.<br/>
 * Repository of CriminalGroup.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Repository
public interface CriminalGroupRepository extends JpaRepository<CriminalGroup, Long> {
}
