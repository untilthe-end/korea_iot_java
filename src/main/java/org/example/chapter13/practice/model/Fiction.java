package org.example.chapter13.practice.model;

import lombok.Getter;

@Getter
public class Fiction extends Book {
    private String genre; // 추리, 로맨스, 미스터리, 판타지

    public Fiction(String id, String title, String author, String genre) {
        super(id, title, author); // 추상 클래스의 생성자 호출
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() + ", Genre: " + genre;
    }
}
