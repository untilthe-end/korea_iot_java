package org.example.chapter12.controller;

import org.example.chapter12.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    // 실제 Book 객체들이 저장되는 리스트
    private List<Book> books;
//    private final List<Book> books = new ArrayList<>();
    // >> 코드 간결화, 초기값 확인에 용이

    // 생성자 주입 형식
    // >> 유연성 증가: 생성자를 통해 다른 리스트로 주입 가능(ex. 테스트용 더미 리스트)
    // >> 의존성 주입(DI) 구조로 변경 가능
    // - 코드 복잡성 증가
    // 미리 값을 넣어, 임시로 테스트하는 용
    public BookController(List<Book> books) {
        this.books = books;
    }

    // 1. 책 추가(요청: 책 데이터, 응답: x)
    public void addBook(String title, String author, String publisher) {
        Book newBook = new Book(title, author, publisher);
        books.add(newBook);
    }

    // 2. 전체 책 조회(요청: x / 응답: 책 데이터 리스트)
    public List<Book> getAllBooks() {

        return books;
    }

    // 3. 책 검색 (책 제목)(요청: 검색어 / 응답: 검색된 책 데이터 리스트)
    public List<Book> searchBook(String title) {
        // 공간 생성
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                // 문자열A.contains(문자열B)
                // : A에 B가 포함되었는지 유무를 boolean값으로 반환
                result.add(book);
            }
        }
        return result;
    }
}
