package com.prokhnov.interpolCardIndex.service.Impl;

import com.prokhnov.interpolCardIndex.exceptions.UserWithCurrentEmailAlreadyExistException;
import com.prokhnov.interpolCardIndex.exceptions.UserWithCurrentNameAlreadyExistException;
import com.prokhnov.interpolCardIndex.model.Role;
import com.prokhnov.interpolCardIndex.model.User;
import com.prokhnov.interpolCardIndex.repository.RoleRepository;
import com.prokhnov.interpolCardIndex.repository.UserRepository;
import com.prokhnov.interpolCardIndex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The {@code UserServiceImpl} class implements UserService.<br/>
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) throws AuthenticationException {

        if (user.getUsername() != null
                && userRepository.findByUsername(user.getUsername()) != null
                && userRepository.findByUsername(user.getUsername()).getUsername() != null) {

            throw new UserWithCurrentNameAlreadyExistException("User with username " + user.getUsername() + " already exists");
        }

        if (user.getUsername() != null
                && userRepository.findByEmail(user.getEmail()) != null
                && userRepository.findByEmail(user.getEmail()).getEmail() != null) {

            throw new UserWithCurrentEmailAlreadyExistException("User with email " + user.getEmail() + " already exists");
        }

        Role userRole = roleRepository.findByRole("USER");
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        if (userRole != null && userRole.getRole().equals("USER")) {
            user.setRoles(roles);
        } else {
            Role role = new Role();
            role.setRole("USER");
            roleRepository.save(role);
            save(user);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with ID: " + id));
    }

    @Override
    public void update(User user) {
        boolean present = userRepository.findById(user.getId()).isPresent();

        if (present){
            user.setRoles(userRepository.findById(user.getId()).get().getRoles());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }


}
