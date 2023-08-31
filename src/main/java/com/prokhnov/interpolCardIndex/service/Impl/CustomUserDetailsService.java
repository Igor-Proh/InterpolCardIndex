package com.prokhnov.interpolCardIndex.service.Impl;

import com.prokhnov.interpolCardIndex.model.Role;
import com.prokhnov.interpolCardIndex.model.User;
import com.prokhnov.interpolCardIndex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * The {@code CustomUserDetailsService} class implements UserDetailsService.<br/>
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Transactional
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

@Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User appUser = userRepository.findByUsername(username);

            if (appUser == null) {
                throw new UsernameNotFoundException("User not found");
            }

            return new org.springframework.security.core.userdetails.User(
                    appUser.getUsername(),
                    appUser.getPassword(),
                    getAuthorities(appUser));

        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }
    }

    private Set<GrantedAuthority> getAuthorities(User appUser) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : appUser.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
}
