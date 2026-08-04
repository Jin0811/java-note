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
         * 9
         *
         * 2. duration.toMinutes() 输出多少？
         * 150
         *
         * 3. Period 和 Duration 分别适合什么场景？
         * Period适合获取年月日分别的间隔，譬如相隔了X年X月X日
         * Duration获取的是总量，适合计算间隔总量的场景
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：period.getDays() 输出多少？
         * 答：9。8 月 1 日 → 8 月 10 日，间隔 9 天。
         *     注意这里的"幸运"：同月内 getDays() 恰好等于总天数。
         *     一旦跨月（如 1 月 1 日 → 3 月 15 日），getDays() 只给"日"那一段
         *     （= 14，不是 73），因为 Period 是按 年/月/日 分部件存的。
         *
         * 问题 2：duration.toMinutes() 输出多少？
         * 答：150。10:00 → 12:30 = 2 小时 30 分，toMinutes() 做总量换算：
         *     2*60 + 30 = 150。Duration 内部只存 seconds+nanos，
         *     toXxx() 都是拿总秒数现算的。
         *
         * 问题 3：Period 和 Duration 分别适合什么场景？
         * 答：记住一句话——Period 是"分解视图"，Duration 是"总量视图"。
         *     Period：按年/月/日分部件存，适合做"隔了 X 年 X 月 X 天"
         *             这类人类日历文案；配套 LocalDate。
         *     Duration：把间隔摊平成单一单位的总量（分/时/秒），
         *             适合程序里做总量计算；配套 LocalTime/LocalDateTime。
         *     补充选型约束：Period.between 收 LocalDate，
         *     Duration.between 收 LocalTime/LocalDateTime，
         *     传错类型会抛 UnsupportedTemporalTypeException。
         */
    }
}
