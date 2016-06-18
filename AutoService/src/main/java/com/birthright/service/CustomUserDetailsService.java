package com.birthright.service;


import com.birthright.entity.Users;
import com.birthright.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Users user = usersRepository.findByEmail(email);
        if (user == null) return null;
        return new CustomUserDetails(user);
    }

}
