package org.example.chapter10.practice02.repository;

import org.example.chapter10.practice02.entity.Item;

import java.util.Set;

// DB를 대신하는 자바 내부의 저장소
// - ItemRepository: DB와 어떠한 행위를 할 것인지 약속 (interface)
// - InMemoryItemRepository: 데이터 처리에 대한 실질적인 행위 구현 (class)
public interface ItemRepository {
    void addItem(Item item);

    Set<Item> findAll();
    Item findById(String itemId); // 단건 조회
    void removeItem(String itemId);
}

/*
    set 형태는 중복/ 순차 x
 */