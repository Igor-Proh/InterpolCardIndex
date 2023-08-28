package com.prokhnov.interpolCardIndex.repository;

import com.prokhnov.interpolCardIndex.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * The {@code UserRepository} interface extends {@code JpaRepository}.<br/>
 * Repository of User.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
