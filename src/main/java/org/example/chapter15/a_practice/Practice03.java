package org.example.chapter15.a_practice;

// Optional 예시: 사용자 조회 //

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Practice03 {
    // 1. User 클래스 정의

    @AllArgsConstructor
    @Getter
    static class User {
        private String id;
        private String name;
    }

    // 2. UserRepository 역할을 하는 클래스
    static class UserRepository {
        private final Map<String, User> userDb = new HashMap<>();

        // 생성자에 기본 사용자 추가
        public UserRepository() {
            userDb.put("user01", new User("user01", "이승아"));
            userDb.put("user02", new User("user02", "이도경"));
        }

        // Optional을 반환하는 조회 ㅔ서드
        public Optional<User> findById(String id) {
            return Optional.ofNullable(userDb.get(id)); // null 일수도 있어서 ofNullable
        }
    }

    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        // (1) 존재하는 사용자 조회
        Optional<User> user1 = repository.findById("user01");
        user1.ifPresent((u -> System.out.println("사용자 이름: " + u.getName())));

        // (2) 존재하지 않는 사용자 처리1: 기본값 반환
        User user2 = repository.findById("user00").orElse(new User("default", "기본 사용자"));
        System.out.println("사용자 이름: " + user2.getName());

        // (3) 존재하지 않는 사용자 처리2: 기본값 생성 함수 사용
        User user3 = repository.findById("user99").orElseGet(() -> new User("temp", "임시 사용자"));
        System.out.println("사용자 이름: " + user3.getName());

        // (4) 존재하지 않는 사용자 처리3: 예외 발생
        try {
            User user4 = repository.findById("user404").orElseThrow(() -> new Exception("사용자를 찾을 수 없습니다."));
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
