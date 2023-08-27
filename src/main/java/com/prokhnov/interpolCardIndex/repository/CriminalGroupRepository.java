package com.prokhnov.interpolCardIndex.repository;

import com.prokhnov.interpolCardIndex.model.CriminalGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriminalGroupRepository extends JpaRepository<CriminalGroup, Long> {
}
