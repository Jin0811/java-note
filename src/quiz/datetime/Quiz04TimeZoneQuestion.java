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
         * 时区
         *
         * 2. withZoneSameInstant 的含义是什么？
         * 不清楚
         *
         * 3. 上海 2026-08-04 14:30 对应 UTC 几点？
         * 6点
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：ZonedDateTime 比 LocalDateTime 多了什么？
         * 答：时区信息。ZonedDateTime ≈ LocalDateTime + ZoneId，
         *     所以它除了日期时间，还能打印出偏移量（+08:00）
         *     和时区名（[Asia/Shanghai]）。
         *
         * 问题 2：withZoneSameInstant 的含义是什么？
         * 答：Same Instant = "同一个物理瞬间"。
         *     保持指向的那一刻不变，换成另一个时区的钟面读数：
         *     上海 14:30(+08:00) 和 UTC 06:30(+00:00) 是同一刻，
         *     只是表盘不同。这正是时区换算的标准姿势。
         *     对照记忆：还有一个 withZoneSameLocal——
         *     它保持"14:30"这几个数字不变、只换时区标签，
         *     结果指向的其实是另一瞬间，业务里很少用，别混。
         *     JS 类比：≈ dayjs.tz 换时区展示（同一刻），而不是改数字。
         *
         * 问题 3：上海 2026-08-04 14:30 对应 UTC 几点？
         * 答：06:30（不是"6 点"——分钟也要跟着换算！）。
         *     上海 = UTC+8，UTC = 14:30 − 8:00 = 06:30。
         *     常见误区就是只减小时、漏掉分钟。
         *     实际打印的第二行也验证了这点：2026-08-04T06:30Z。
         */
    }
}
