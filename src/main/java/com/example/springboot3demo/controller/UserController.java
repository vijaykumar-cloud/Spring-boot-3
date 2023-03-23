package com.example.springboot3demo.controller;

import com.example.springboot3demo.model.User;
import com.example.springboot3demo.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("client/user")
public class UserController {

    @Autowired
    UserClientService userClientService;

    @GetMapping("/")
    public Flux<User> getAll() {
        return userClientService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable Long id) {
        return userClientService.getById(id);
    }

}
