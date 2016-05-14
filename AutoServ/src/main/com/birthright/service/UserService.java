package com.birthright.service;

import com.birthright.entity.Users;
import com.birthright.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Birthright on 02.05.2016.
 */
@Component
@Service
public class UserService {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UsersRepository usersRepository;

    public void saveUser(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        usersRepository.save(user);
    }
}
