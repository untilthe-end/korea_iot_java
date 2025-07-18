package org.example.chapter09_O;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

// == 생일까지 남은 일수를 계산하는 프로그램 == //
// : 사용자로부터 생년월일 입력받고, 다가오는 생일까지 남은 일수 반환
// 1. 사용자로부터 생년월일 입력 받기 (형식 YYYY-MM-DD)
// 2. 사용자의 입력을 LocalDate 타입으로 변환 (yyyy-MM-dd): formatter
// LocalDate.parse(a,b) - a를 b의 형태로 재구성
// 3. 현재 날짜 구하기
// 4. 올해의 생일 계산
// .withYear(): 년도를 조작하는 메서드
// .with~()
// 5. 생일이 이미 지났거나 당일인 경우 년도값을 내년으로 설정
// 6. 남은 일수 계산
// ChronoUnit.Days: java.time 패키지에서 날짜와 시간 간의 차이를 계산할 때 사용
// .between(a,b): a와 b 사이의 날짜 | 시간 차이를 반환
public class Practice {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("생년월일 입력: (YYYY-MM-DD)");
        String inputDate = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 1997-03-14

        // inputDate를 위에서 정한 formatter 형식으로 바꿔서 LocalDate 타입으로 넣어줘
        LocalDate birthdate = LocalDate.parse(inputDate, formatter);

        // 오늘 날짜 구해줘.
        LocalDate today = LocalDate.now(); // 2025-07-09

        // 내 생일의 년도를 오늘 날짜의 년도로 바꿔줘 (내년 생일)
        LocalDate nextBirthday = birthdate.withYear(today.getYear()); // 2025-03-14

        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1); // 2026-03-14
        }
        long daysUtilNextBirthday = ChronoUnit.DAYS.between(today, nextBirthday);

        System.out.println("남을 생일까지 " + daysUtilNextBirthday + "일 남았습니다.");

    }
}
