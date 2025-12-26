package com.personal.webpage.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepo;

    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
        userRepo.addUser(new UserData(1, "john_doe", "john_doe@email.com", java.time.LocalDateTime.now()));
    }

    @GetMapping("/")
    public List<UserData> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public UserData getUserById(@PathVariable("id") Integer id) {
        Optional<UserData> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID " + id + " not found.");
        }
    }

    //post
    @PostMapping("/add/{username/email}/{pwd}")
    public void create(@RequestBody UserData data) {
        if (data.username() == null && data.email() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter either valid username or email");
        }
        // In a real application, you would save the user to a database
        userRepo.addUser(data);
    }

}
