package com.prueba_tecnica.videoClub_api.service;


import com.prueba_tecnica.videoClub_api.modelo.User;
import com.prueba_tecnica.videoClub_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public void saveUser(User user){
        System.out.println(user.getPassword());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        repository.save(user);
    }
}
