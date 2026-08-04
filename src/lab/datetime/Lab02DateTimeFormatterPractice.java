package lab.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Lab02DateTimeFormatterPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：日期时间格式化和解析。
         *
         * TODO:
         * 1. 创建 LocalDateTime。
         * 2. 使用 yyyy-MM-dd HH:mm:ss 格式化为字符串。
         * 3. 把字符串解析回 LocalDateTime。
         */

        LocalDateTime time = LocalDateTime.of(2026, 8, 4, 14, 30, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatted = time.format(formatter);
        LocalDateTime parsed = LocalDateTime.parse("2026-08-04 14:30:00", formatter);

        System.out.println(formatted);
        System.out.println(parsed);
    }
}
