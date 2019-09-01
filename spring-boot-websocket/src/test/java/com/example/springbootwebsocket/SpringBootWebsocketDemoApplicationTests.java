package com.example.springbootwebsocket;

import com.example.springbootwebsocket.controller.UserController;
import com.example.springbootwebsocket.model.User;
import com.example.springbootwebsocket.model.UserResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebsocketDemoApplicationTests {

    @Test
    public void testUserResponse() {
        UserController userController = new UserController();
        UserResponse userResponse= userController.getUser(new User("Jenny"));
        Assert.assertEquals(userResponse.getContent(), "Hello, Jenny");
    }

}