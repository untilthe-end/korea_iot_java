package org.example.test0717.프로그래밍응용.book_management_system.service;


import org.example.test0717.프로그래밍응용.book_management_system.exception.BookNotFoundException;
import org.example.test0717.프로그래밍응용.book_management_system.model.Book;

import java.util.List;

public interface BookService {

    void addBooks(String id, String title, String author) ;

    void getAllBooks();

    void searchByBookTitle(String title);

    void searchByBookId(String id);

    void updateBookAuthor(String id, String newAuthor);

    void deleteBook(String id) throws BookNotFoundException;

}
