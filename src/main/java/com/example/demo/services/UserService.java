package com.example.demo.services;

import com.example.demo.model.Email;
import com.example.demo.model.User;
import com.example.demo.repositery.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class UserService {
   @Autowired
   UserRepository repository;


    public User save(User user){
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }
    public User getUserById(Long id){
        return repository.findById(id).orElse(null);
    }


}
