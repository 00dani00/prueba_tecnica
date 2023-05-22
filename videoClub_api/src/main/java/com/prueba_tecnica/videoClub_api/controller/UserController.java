package com.prueba_tecnica.videoClub_api.controller;

import com.prueba_tecnica.videoClub_api.modelo.Movie;
import com.prueba_tecnica.videoClub_api.modelo.User;
import com.prueba_tecnica.videoClub_api.service.MovieService;
import com.prueba_tecnica.videoClub_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/login/register")
    public void saveUser(@RequestBody User user){
        service.saveUser(user);
    }
}
