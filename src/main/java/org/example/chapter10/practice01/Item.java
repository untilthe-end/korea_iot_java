package org.example.chapter10.practice01;

// 시스템의 제품이 가져야 할 기본 속성과 메서드
abstract class Item {
    private final String id; // 제품 고유 번호
    private final String name; // 제품명

    // 생성자로 final 테이터 값 주입
    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract void display();
}
