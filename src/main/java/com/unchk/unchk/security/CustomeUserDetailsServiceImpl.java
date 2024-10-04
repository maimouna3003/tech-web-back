package com.unchk.unchk.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.unchk.unchk.models.UserApp;
import com.unchk.unchk.services.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomeUserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserApp userSearch = userService.loadUserByUsername(username);
        if (userSearch == null)
            throw new UsernameNotFoundException("no existe userName");

        UserDetails userDetails = User.builder().username(userSearch.getEmail()).password(userSearch.getPassword())
                .roles(userSearch.getProfil().name())
                .build();

        return userDetails;
    }

}
