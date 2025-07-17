package org.example.test0717.프로그래밍응용.book_management_system.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message) {
        System.out.println(message);
    }
}
