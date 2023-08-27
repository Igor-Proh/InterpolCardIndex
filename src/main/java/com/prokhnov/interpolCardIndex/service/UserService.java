package com.prokhnov.interpolCardIndex.service;

import com.prokhnov.interpolCardIndex.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findByUsername(String username);

    void save(User user);

    List<User> findAllUsers();

    void deleteUserById(Long userId);

    User getUserById(Long id);
}
