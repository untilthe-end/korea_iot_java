package org.example.chapter09_practice2.service;

import org.example.chapter09_practice2.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    User findUserById(int id);

    List<User> findUsersByName(String name);

    void updateUserEmail(int id, String email);

    void deleteUser(int id);
}
