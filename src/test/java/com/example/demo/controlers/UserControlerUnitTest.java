package com.example.demo.controlers;

import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.Test;

import org.junit.Assert;
import org.mockito.Mockito;


import static org.mockito.Mockito.when;

public class UserControlerUnitTest {

    @Test
    public void saveUser(){
        UserService userService = Mockito.mock(UserService.class);
        User user = new User("abdo","haddadi","abdo23@gmail.com","09876543");

        when(userService.save(user)).thenReturn(user);

      Assert.assertEquals(userService.save(user).getFirstName(),"abdo");
    }
}
