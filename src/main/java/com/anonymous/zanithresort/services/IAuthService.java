package com.anonymous.zanithresort.services;

import com.anonymous.zanithresort.models.User;

public interface IAuthService {
    public User  save (User user);
    public User login (String email);
}
