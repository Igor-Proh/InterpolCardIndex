package com.prokhnov.interpolCardIndex.repository;

import com.prokhnov.interpolCardIndex.model.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

}
