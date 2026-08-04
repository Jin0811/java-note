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

        LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeStr = time1.format(timeFormatter);
        LocalDateTime time2 = LocalDateTime.parse(timeStr, timeFormatter);

        System.out.println(timeStr);
        System.out.println(time2);
    }
}
