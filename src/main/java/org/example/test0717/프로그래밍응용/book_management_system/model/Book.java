package org.example.test0717.프로그래밍응용.book_management_system.model;

import org.example.test0717.프로그래밍응용.book_management_system.util.DateUtil;

import java.time.LocalDateTime;

public class Book {
    private String id;
    private String title;
    private String author;
    private String createdAt;
    private String updatedAt;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createdAt = DateUtil.now();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUpdatedAt() {
        this.updatedAt = DateUtil.now();
    }

    @Override
    public String toString() {
        return
                "책번호: '" + id + '\'' +
                ", 제목: '" + title + '\'' +
                ", 저자: '" + author + '\'' +
                ", 생성 날짜: '" + createdAt + '\''
                ;
    }
}
