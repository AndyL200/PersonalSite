package com.personal.webpage.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private List<UserData> users = new ArrayList<>();

    UserRepository() {
    }

    void addUser(UserData user) {
        users.add(user);
    }

    List<UserData> findAll() {
        return users;
    }

    Optional<UserData> findById(Integer id) {
        return users.stream()
            .filter(user -> user.uid().equals(id))
            .findFirst();
    }

     
}
