package com.prokhnov.interpolCardIndex.service;

import com.prokhnov.interpolCardIndex.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The {@code UserService} interface.<br/>
 * Service layer of User.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Service
public interface UserService {
    User findByUsername(String username);

    void save(User user);

    List<User> findAllUsers();

    void deleteUserById(Long userId);

    User getUserById(Long id);

    void update(User user);
}
