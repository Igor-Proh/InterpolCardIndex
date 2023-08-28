package com.prokhnov.interpolCardIndex.repository;

import com.prokhnov.interpolCardIndex.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * The {@code RoleRepository} interface extends {@code JpaRepository}.<br/>
 * Repository of Role.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
