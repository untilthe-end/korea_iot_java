package org.example.test0717.프로그래밍응용.book_management_system.service;

import org.example.test0717.프로그래밍응용.book_management_system.exception.BookNotFoundException;
import org.example.test0717.프로그래밍응용.book_management_system.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    List<Book> booksList = new ArrayList<>();
    //  int nextId = 1;

    @Override
    public void addBooks(String id, String title, String author) {
        Book book = new Book(id, title, author);
        booksList.add(book);
    }

    @Override
    public void getAllBooks() {
        for (Book book : booksList) {
            System.out.println(book);
        }
    }

    @Override
    public void searchByBookTitle(String title) {
        for (Book book : booksList) {
            if (book.getTitle().equals(title)) {
                System.out.println(book);
            } else {
                throw new BookNotFoundException(title + " 책은 없습니다.");
            }
        }
    }

    @Override
    public void searchByBookId(String id) {
        for (Book book : booksList) {
            if (book.getId().equals(id)) {
                System.out.println(book);
            } else {
                throw new BookNotFoundException(id + "번 책은 없습니다.");
            }
        }
    }

    @Override
    public void updateBookAuthor(String id, String newAuthor) {
        for (Book book : booksList) {
            if (book.getId().equals(id)) {
                book.setAuthor(newAuthor);
                book.setUpdatedAt();
            } else {

            }
        }
        throw new BookNotFoundException(id + "를 확인해주세요.");
    }

    @Override
    public void deleteBook(String id) {

        for (Book book : booksList) {
            if (book.getId().equals(id)) {
                booksList.remove(book);
            }
        }
        throw new BookNotFoundException("다시 입력 해주세요.");
    }
}
