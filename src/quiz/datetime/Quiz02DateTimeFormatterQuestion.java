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

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * 2026-08-04 14:30:05
         * 2026-08-04T14:30:05
         *
         * 问题 1：把 LocalDateTime 按指定格式转成字符串。
         *
         * 问题 2：把符合格式的字符串解析回 LocalDateTime。
         *
         * 问题 3：格式符大小写含义不同。MM 表示月份，mm 表示分钟；
         *     HH 表示 24 小时制小时，hh 表示 12 小时制小时。
         */
    }
}
