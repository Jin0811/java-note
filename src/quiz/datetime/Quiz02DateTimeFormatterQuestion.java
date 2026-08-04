package quiz.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Quiz02DateTimeFormatterQuestion {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.of(2026, 8, 4, 14, 30, 5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String text = time.format(formatter);
        LocalDateTime parsed = LocalDateTime.parse(text, formatter);

        System.out.println(text);
        System.out.println(parsed);

        /*
         * 问题：
         * 1. format 的作用是什么？
         * 2. parse 的作用是什么？
         * 3. yyyy 和 MM 为什么大小写不能随便改？
         */
    }
}
