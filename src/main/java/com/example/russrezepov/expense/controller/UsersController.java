package com.example.russrezepov.expense.controller;

import com.example.russrezepov.expense.model.Users;
import com.example.russrezepov.expense.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsersController {
    private UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        super();
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users")
    Collection<Users> users() {
        //select * from users
        return usersRepository.findAll();
    }

    @GetMapping("/users/{id}")
    ResponseEntity<?> getUsers(@PathVariable Long id) {
        Optional<Users> users = usersRepository.findById(id);
        return users.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //INSERT INTO TABLE implementation
    @PostMapping("/users{id}")
    ResponseEntity<Users> createUsers(@Valid @RequestBody Users users) throws URISyntaxException {
        Users result = usersRepository.save(users);
        return ResponseEntity.created(new URI("/api/users" + result.getId())).body(result);
    }

    @PutMapping("/users/{id}")
    ResponseEntity<Users> updateUsers(@Valid @RequestBody Users users) {
        Users result = usersRepository.save(users);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/users/{id}")
    ResponseEntity<?> deleteUsers(@PathVariable Long id) {
        usersRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
