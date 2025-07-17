package org.example.test0717.프로그래밍응용.book_management_system.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static final String FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMAT);

    public static String now() {
        return LocalDateTime.now().format(FORMATTER);
    }
}
