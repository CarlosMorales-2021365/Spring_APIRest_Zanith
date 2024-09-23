package com.anonymous.zanithresort.service;

import com.anonymous.zanithresort.model.User;

public interface IUserService {
    public User  save (User user);
    public User login (String email);
}
