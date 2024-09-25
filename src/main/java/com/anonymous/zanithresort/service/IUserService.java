package com.anonymous.zanithresort.service;
import java.util.List;

import com.anonymous.zanithresort.model.User;

public interface IUserService {
    public List <User> list();
    public User  save (User user);
    public User login (String email);
    public void delete(User user);
    public User find (Integer id);
    Integer getNextId();
}
