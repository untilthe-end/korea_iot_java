package org.example.chapter13.practice.service;

import org.example.chapter13.practice.model.Book;
import org.example.chapter13.practice.repository.BookRepository;

import java.util.List;

public class BookServiceImpl implements BookManager<Book> {
    private static BookServiceImpl instance;

    private final BookRepository repository = BookRepository.getInstance();

//    private BookServiceImpl() {};

    public static BookServiceImpl getInstance() {
        if (instance == null) {
            instance = new BookServiceImpl();
        }
        return instance;
    }

    @Override
    public void addBook(Book book) {
        Book addedBook = repository.save(book); // 저장 완료 시 Book 데이터, 실패시 null 반환

        if (addedBook == null) {
            System.out.println("해당 ID의 도서가 이미 존재하여 책이 추가되지 않았습니다.");
        } else {
            System.out.println(book.getTitle() + "(이)가 추가되었습니다.");
        }
    }

    @Override
    public Book findBookById(String id) {
        Book book = repository.findById(id);

        if (book == null) {
            System.out.println("ID [" + id + "]에 해당하는 도서를 찾을 수 없습니다.");
        }
        return book;
    }

    @Override
    public List<Book> listAllBooks() {
        return repository.findAll();
    }

    @Override
    public void updateBook(String id, Book updatedBook) {
        // 수정: id와 일치하는 기존의 데이터 삭제 + 신규(수정된) 데이터 저장

        Book existingBook = repository.findById(id);

        if (existingBook == null) {
            // 수정할 책이 존재하지 x
            System.out.println("ID [" + id + "]에 해당하는 도서를 찾을 수 없습니다.");
         return;
        }

        // 수정할 책이 존재 O
        repository.delete(id);
        addBook(updatedBook);
    }

    @Override
    public void deleteBook(String id) {
        Book existingBook = findBookById(id);

        if (existingBook == null) {
            // 삭제할 책이 존재하지 x
            System.out.println("ID [" + id + "]에 해당하는 도서를 찾을 수 없습니다.");
            return;
        }
        repository.delete(id);
        System.out.println(existingBook.getTitle() + "이(가) 삭제되었습니다.");
    }
}
