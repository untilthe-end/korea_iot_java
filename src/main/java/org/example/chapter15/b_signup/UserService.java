package org.example.chapter15.b_signup;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    public static User signUp(UserSignUpRequestDto dto) {
        User user = null;

        try {
            // 회원 데이터 유효성 검증
            // : 비밀번호와 비밀번호 확인 값의 일치 유무 검증
            String password = dto.getPassword();
            String passwordCheck = dto.getPasswordCheck();

            if (!password.equals(passwordCheck)) {
                // 일치하지 않는 경우 예외 발생
                throw new Exception("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            }

            Long id = 1L; // 데이터베이스 역할을 대신
            Date nowDate = new Date(); // 회원가입하는 시점을 저장

            user = User.builder()
                    .id(id)
                    .username(dto.getUsername())
                    .password(password)
                    .name(dto.getName())
                    .email(dto.getEmail())
                    .phone(dto.getPhone())
                    .nickname(dto.getNickname())
                    .signUpDate(nowDate)
                    .build();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public static void main(String[] args) {
        // 1) 사용자로 부터 요청값을 받음 (UserSignUpRequestDto 형식)
        // 2) 요청값 검증
        // 3) User 형식으로 데이터 저장
        // 4) User 타입 반환

        UserSignUpRequestDto dto1 = new UserSignUpRequestDto(
                "qwer123", "123123", "123123",
                "이승아", "qwe123@naver.com", "010-1111-2222", "개구리"
        );
        User user1 = signUp(dto1);
        System.out.println(user1.getSignUpDate());

        UserSignUpRequestDto dto2 = new UserSignUpRequestDto(
                "qwer123", "123123", "123123",
                "이후후", "qqqq@naver.com", "010-0000-0000", "황소"
        );
        User user2 = signUp(dto2);
        System.out.println(user1.getSignUpDate());

        List<User> userList = null;

        List<UserSignUpRequestDto> dtos = new ArrayList<>();
        dtos.add(dto1);
        dtos.add(dto2);

        userList = dtos.stream()
                //.map(dto -> signUp(dto))
                .map(UserService::signUp)
                .collect(Collectors.toList());
        userList.forEach(System.out::println);
    }
}