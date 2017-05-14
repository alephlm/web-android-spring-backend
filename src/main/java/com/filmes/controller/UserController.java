package com.filmes.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.filmes.model.User;
import com.filmes.service.UserService;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Collections;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public Principal user(Principal user) {
      return user;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public User registration(@RequestBody User user) {

        User u = new User(user.getUsername(), user.getPassword());

        return userService.save(u);
    }
    
    @RequestMapping(value = "/favoritar/{id}", method = RequestMethod.GET)
    public String registration(@PathVariable Long id) {
        userService.favoritar(id);
        return "OK";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "OK";
    }
}