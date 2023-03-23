package com.example.springboot3demo.service;

import com.example.springboot3demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@HttpExchange(url = "/users", accept = "application/json", contentType = "application/json")
public interface UserClientService {
    @GetExchange("/")
    Flux<User> getAll();

    @GetExchange("/{id}")
    Mono<User> getById(@PathVariable("id") Long id);

    @PostExchange("/")
    Mono<ResponseEntity<Void>> save(@RequestBody User user);

    @PutExchange("/{id}")
    Mono<ResponseEntity<Void>> update(@PathVariable Long id, @RequestBody User user);

    @DeleteExchange("/{id}")
    Mono<ResponseEntity<Void>> delete(@PathVariable Long id);

}
