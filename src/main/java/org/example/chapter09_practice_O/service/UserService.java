package org.example.chapter09_practice_O.service;

import org.example.chapter09_practice_O.model.User;
import java.util.List;

// 인터페이스의 특징
// 내부의 멤버(변수, 메서드)는 각각 public static final, public abstract 생략

// 1. 사용자 등록(추가)
// 요청값: 사용자 정보, 반환값: X
// 추상 메서드 (구현x)

// 2. 사용자 조회(단건)
// 요청값: 사용자 특정 값, 반환값: 단일 사용자 정보

// 3. 사용자 조회(전체)
// 요청값: x, 반환값: 전체 사용자 정보(배열)

// 4. 사용자 수정
// 요청값: 사용자 특정값, 새로운 이메일값, 반환값: x

// 5. 사용자 삭제
// 요청값: 사용자 특정값, 반환값: x

// 6. 사용자 필터링(이름)
// 요청값: 조회하고자 하는 이름
public interface UserService {

    void addUser(User user);

    User getUserById(int id);
    List<User> getAllUsers();

    void updateUserEmail(int id, String newEmail);

    void deleteUser(int id);

    List<User> findUsersByName(String name);


}
