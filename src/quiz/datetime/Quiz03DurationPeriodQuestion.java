package quiz.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Quiz03DurationPeriodQuestion {
    public static void main(String[] args) {
        Period period = Period.between(
                LocalDate.of(2026, 8, 1),
                LocalDate.of(2026, 8, 10)
        );

        Duration duration = Duration.between(
                LocalDateTime.of(2026, 8, 4, 10, 0),
                LocalDateTime.of(2026, 8, 4, 12, 30)
        );

        System.out.println(period.getDays());
        System.out.println(duration.toMinutes());

        /*
         * 问题：
         * 1. period.getDays() 输出多少？
         * 2. duration.toMinutes() 输出多少？
         * 3. Period 和 Duration 分别适合什么场景？
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * 9
         * 150
         *
         * 问题 1：输出 9，8 月 1 日到 8 月 10 日相差 9 天。
         *
         * 问题 2：输出 150，10:00 到 12:30 相差 2.5 小时。
         *
         * 问题 3：Period 适合年月日这种日期间隔；
         *     Duration 适合小时、分钟、秒这种精确时间间隔。
         */
    }
}
