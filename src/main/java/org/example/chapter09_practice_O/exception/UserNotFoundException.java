package org.example.chapter09_practice_O.exception;

// 사용자 예외 클래스
public class UserNotFoundException extends RuntimeException {
    // 실행 이전에는 예외 발생 x
    public UserNotFoundException(String message) {
        super(message);
        // 우리가 만든 형태의 오류메세지를 e.getMessage()하려면
        // super(message)해줘야됨
    }
}
