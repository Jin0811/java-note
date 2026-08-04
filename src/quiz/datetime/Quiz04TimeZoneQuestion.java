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

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出类似：
         * 2026-08-04T14:30+08:00[Asia/Shanghai]
         * 2026-08-04T06:30Z[UTC]
         *
         * 问题 1：多了时区信息，例如 Asia/Shanghai。
         *
         * 问题 2：表示同一个真实时间点，换成另一个时区展示。
         *
         * 问题 3：UTC 06:30。上海是 UTC+8，所以减 8 小时。
         */
    }
}
