package com.anonymous.zanithresort.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anonymous.zanithresort.model.User;
import com.anonymous.zanithresort.repository.UserRepository;

@Service
public class UserService implements IUserService{ 
    @Autowired
    private UserRepository authRepository;

    @Override
    public User save (User user){
        return authRepository.save(user);
    }

    @Override
    public User login (String email){
        return authRepository.findByEmail(email);
        
    }


}
