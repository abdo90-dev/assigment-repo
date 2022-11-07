package com.example.demo.controlers;

import com.example.demo.model.Email;
import com.example.demo.model.User;
import com.example.demo.services.EmailService;
import com.example.demo.services.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RunWith(SpringRunner.class)
@RestController
public class UserControler {
    @Autowired
    UserService service;
    @Autowired
    EmailService emailService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return service.findAll();
    }
    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {

        User newStudent = service.save(user);
        return new ResponseEntity<User>(newStudent, HttpStatus.CREATED);
   }
   @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        return service.getUserById(id);

   }
    @PostMapping("/email")
    public ResponseEntity<Email> addEmail(@RequestBody Email email) {

        Email newEmail = emailService.createEmail(email);
        return new ResponseEntity<Email>(newEmail, HttpStatus.CREATED);
    }
    @GetMapping("/emails/count?user={userID}")
    public int emailsNum(@RequestParam Long useID){
         User user =     this.getUserById(useID);
         return emailService.getEmailsByUserId(user.getEmail());

    }


}
