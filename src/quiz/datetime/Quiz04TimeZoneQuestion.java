package quiz.datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Quiz04TimeZoneQuestion {
    public static void main(String[] args) {
        ZonedDateTime shanghai = ZonedDateTime.of(
                2026, 8, 4, 14, 30, 0, 0,
                ZoneId.of("Asia/Shanghai")
        );
        ZonedDateTime utc = shanghai.withZoneSameInstant(ZoneId.of("UTC"));

        System.out.println(shanghai);
        System.out.println(utc);

        /*
         * 问题：
         * 1. ZonedDateTime 比 LocalDateTime 多了什么？
         * 2. withZoneSameInstant 的含义是什么？
         * 3. 上海 2026-08-04 14:30 对应 UTC 几点？
         */
    }
}
