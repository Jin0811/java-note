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
         * 日期，年月日
         *
         * 2. LocalTime 表示什么？
         * 时间，时分秒
         *
         * 3. LocalDateTime 是否包含时区？
         * 不包含
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：LocalDate 表示什么？
         * 答：日期，只有年月日，没有时分秒、也没有时区。
         *     例：2026-08-04。打印即 ISO 格式。
         *
         * 问题 2：LocalTime 表示什么?
         * 答：时间，只有时分秒（还能精确到纳秒），没有日期、没有时区。
         *     例：LocalTime.of(14, 30) → 打印为 14:30（秒为 0 时省略）。
         *
         * 问题 3：LocalDateTime 是否包含时区？
         * 答：不包含。LocalDateTime = LocalDate + LocalTime 的合并，
         *     描述"某天的某个时刻"，但不绑定任何时区。
         *     需要时区得换 ZonedDateTime（LocalDateTime + 时区）。
         *     本例 of(date, time) 就是把日期和时间拼成 LocalDateTime：
         *     2026-08-04 + 14:30 → 2026-08-04T14:30（中间的 T 是 ISO 日期时间分隔符）。
         */
    }
}
