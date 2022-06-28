package com.challenge.itau.users.service.impl;

import com.challenge.itau.users.entity.User;
import com.challenge.itau.users.repository.UserRepository;
import com.challenge.itau.config.security.UserSpringSecurity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User with email " + email + " not found!");
        }
        Collection<GrantedAuthority> grantedAuthorities = user
                .getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        UserSpringSecurity userSpringSecurity= new UserSpringSecurity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                grantedAuthorities
        );
        return userSpringSecurity;
    }
}
