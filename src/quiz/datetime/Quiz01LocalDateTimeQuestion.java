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

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * 2026-08-04
         * 14:30
         * 2026-08-04T14:30
         *
         * 问题 1：LocalDate 只表示日期，如年月日。
         *
         * 问题 2：LocalTime 只表示时间，如时分秒。
         *
         * 问题 3：不包含时区。需要时区信息时使用 ZonedDateTime。
         */
    }
}
