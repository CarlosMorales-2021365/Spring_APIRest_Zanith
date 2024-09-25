package com.anonymous.zanithresort.service;
import java.util.List;

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

    @Override
    public List<User> list() {
        return authRepository.findAll();      
        
    }

    @Override
    public void delete(User user) {
        authRepository.delete(user);
    
    }

    @Override
    public User find(Integer id) {
        User user = authRepository.findById(id).orElse(null);
        return user;
    
    }

    @Override
    public Integer getNextId() {
        List<User> users = list(); // Método que deberías implementar para obtener la lista de usuarios
        if (users.isEmpty()) {
            return 1; // O cualquier otro valor inicial que desees
        }
        return users.stream()
                     .mapToInt(User::getId) // Cambia esto si el método de ID es diferente
                     .max()
                     .orElse(0) + 1; // Incrementar el ID más alto
    }


}
