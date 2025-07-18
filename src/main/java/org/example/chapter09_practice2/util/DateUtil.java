package org.example.chapter09_practice2.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String now() {
        return LocalDateTime.now().format(FORMATTER);
                // 현재시간.포맷에 맞춰서 String 으로 반환
    }


    // 문자열 날짜 정보를 LocalDatetime 분석해서 으로 반환해라.
    public static LocalDateTime parse(String datetime) {
        return LocalDateTime.parse(datetime, FORMATTER);
    }
}
