package org.example.chapter13.practice.service;

/*
    도서관리 시스템의 비즈니스 로직을 인터페이스화
    : CRUD 기능
    - 제네릭 타입을 통해 책의 타입을 정의
*/

import java.util.List;

public interface BookManager<T> {
    // T: 타입 변수
    //      - 해당 인터페이스로 실직적인 비즈니스 로직 구현 시 타입 명시

    void addBook(T book);

    T findBookById(String id);
    List<T> listAllBooks();

    void updateBook(String id, T updateBook);
    void deleteBook(String id);
}
