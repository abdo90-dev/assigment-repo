package com.example.demo.services;

import com.example.demo.model.Email;
import com.example.demo.repositery.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Component
public class EmailService {
    @Autowired
    EmailRepository repository;
    public Email createEmail(Email email){
        return repository.save(email);
    }
    public int getEmailsByUserId(String email){
        return repository.findEmailsByFromm(email).size();
    }
    public List<Email> getEmails(){
        return repository.findAll();
    }
    public Email getEmailById(Long id){
        return repository.findById(id).orElse(null);
    }

}
