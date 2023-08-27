package com.prokhnov.interpolCardIndex.repository;

import com.prokhnov.interpolCardIndex.model.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriminalRepository extends JpaRepository<Criminal, Long> {
    List<Criminal> findAllByIsArchivedIsTrue();
    List<Criminal> findAllByIsArchivedIsFalse();
    List<Criminal> findCriminalByCriminalGroupId(Long id);
    List<Criminal> findCriminalByCriminalGroupIsNull();

}
