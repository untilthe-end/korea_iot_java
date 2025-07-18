package org.example.chapter09_O;

// == java.time 패키지 == //
    // ISO-8601 표준을 기반으로 설계
    // : YYYY-MM-DDThh:mm:ss:sssZ 형식
    // - import 문을 사용하여 클래스를 명시

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JavaTime {
    public static void main(String[] args) {
        // 1) 날짜
        
        // of(): 년도, 월, 일 제공하면 국제 표기법 상 표현으로 반환
        LocalDate yesterday = LocalDate.of(2025, 7, 8);
        System.out.println("yesterday = " + yesterday);

        LocalDate today = LocalDate.now();      // now(): 현재 날짜 반환
        System.out.println("today = " + today);

        // .plus(Years, Months, Days): N년 후, N달 후, N일 후
        // .minus(동일): N년/달/일 전
        LocalDate tomorrow = today.plusDays(1);
        System.out.println("tomorrow = " + tomorrow);

        LocalDate oneMonthAgo = today.minusMonths(1);
        System.out.println("oneMonthAgo = " + oneMonthAgo);

        System.out.println("-----------------------------------------------");
        
        // 2) 시간
        LocalTime now = LocalTime.now();
        System.out.println("now = " + now);

        // of(시, 분) || (시, 분, 초) 등 가능1
        LocalTime lunchTime = LocalTime.of(12, 50, 00);
        System.out.println("lunchTime = " + lunchTime);
        
        // .plus(Hours, Minutes, Seconds)
        // .minus(동일)

        System.out.println("-----------------------------------------------");

        // 3) 날짜 & 시간
        // .now(), .of(), .plus(), .minus()
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("nowDateTime = " + nowDateTime);

        // cf) get메서드
        // : getYear(), getMonth(), getDayOfMonth(): 날짜 정보 반환
        // : getHour(), getMinute(), getSecond(): 시간 정보 반환

        System.out.println(today.getYear());
        System.out.println(today.getMonth()); // - 키워드 반환 (영단어)
        System.out.println(today.getDayOfMonth());

        System.out.println("-----------------------------------------------");

        // cf) 날짜/시간 formatting - 원하는 형식으로 출력
        LocalDateTime example = LocalDateTime.now();
        System.out.println(example);

        // DateTimeFormatter: LocalDateTime의 날짜/시간 데이터를 원하는 패턴으로 변경
        // .ofPattern(원하고자 하는 패턴을 문자열로 전달)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy년MM월dd일 HH시 mm분 ss초");

        // cf) 포맷 기호 - 대소문자 구분
        // y(연도), M(월), d(일) | H(시), h(시), m(분), s(초)
        // - H는 24시간제
        // - h는 12시간제

        // 변경할 날짜/시간 데이터.format(원하는 포맷 형식);
        System.out.println(example.format(formatter));

   /*     // 현재 시간 출력하기
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println(nowTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy:MM:dd HH시 mm분 ss초");

        System.out.println(nowTime.format(formatter));*/
    }
}
