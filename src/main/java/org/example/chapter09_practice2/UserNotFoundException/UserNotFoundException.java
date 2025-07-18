package org.example.chapter09_practice2.UserNotFoundException;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
