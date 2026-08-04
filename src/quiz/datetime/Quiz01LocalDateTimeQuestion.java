package quiz.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Quiz01LocalDateTimeQuestion {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2026, 8, 4);
        LocalTime time = LocalTime.of(14, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);

        /*
         * 问题：
         * 1. LocalDate 表示什么？
         * 2. LocalTime 表示什么？
         * 3. LocalDateTime 是否包含时区？
         */
    }
}
