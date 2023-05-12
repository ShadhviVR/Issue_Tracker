
package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class UserController {
    
    
    
       @Autowired
    UserRepository userRep;

    
    
    
    
    
    
    
    @GetMapping("/users")
    public List<User> getAllUsers() {

        return userRep.findAll();
    }
}
