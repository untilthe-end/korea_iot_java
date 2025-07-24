package org.example.chapter16.practice.entity;

import lombok.Getter;

@Getter
public enum Category {
    FICTION, NONFICTION, SCIENCE, HISTORY, FANTASY;

    public static Category fromString(String value) {
        try {
            return Category.valueOf(value);
            // 매개변수 값을 카테고리 타입으로 반환
            // valueOf(인자)에 Category의 상수값과 일치하지 않는 데이터 전달 시
            // : IllegalArgumentException 발생
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid category: " + value);
        }
    }
}
