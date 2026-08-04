package datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/*
  ===== Duration vs Period：两种"时间跨度"，别用混 =====

  计算"两个时间点之间隔了多久"时，Java 按单位拆成类：

    Duration  以【时间】为单位：秒/分/时/天（适合时分秒级的间隔）
              ≈ dayjs 的毫秒级 diff，用于"隔了几分钟/几小时"
    Period    以【日历】为单位：年/月/日（适合按年月日数的间隔）
              ≈ 人类的"几岁/隔了几个月"，处理日历概念

  怎么选：
    两个 LocalTime / LocalDateTime 比间隔  → Duration.between(a, b)
    两个 LocalDate 比间隔                 → Period.between(a, b)
    用错会抛 UnsupportedTemporalTypeException（编译器/运行时拦你）。

  【最容易踩的坑】Duration 和 Period 的"取数"语义不同：
    duration.toMinutes() 返回【总量】换算——2 小时 30 分 → 150 分钟 ✅
    period.getDays()     只返回【天数那一段】——跨月的话只给"日"部分！
    例如 Period.between(1月1日, 3月15日).getDays() = 14（不是 73），
    因为 Period 拆成 2 个月 + 14 天。要拿"总天数"得用别的算法。
*/

public class DurationPeriodDemo {
    public static void main(String[] args) {
        // ---- Period：按"日历"算间隔（年/月/日）----
        LocalDate startDate = LocalDate.of(2026, 8, 1);
        LocalDate endDate = LocalDate.of(2026, 8, 10);
        Period period = Period.between(startDate, endDate);   // 8/1 → 8/10

        // 同月内 getDays() 恰好等于总天数；跨月时它只给"日"那段，要小心。
        System.out.println("days = " + period.getDays());     // 9

        // ---- Duration：按"时间"算间隔（秒/分/时）----
        LocalDateTime startTime = LocalDateTime.of(2026, 8, 3, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2026, 8, 3, 12, 30);
        Duration duration = Duration.between(startTime, endTime);  // 10:00 → 12:30

        // toMinutes() 是【总量】换算：2 小时 30 分 → 150 分钟。
        System.out.println("minutes = " + duration.toMinutes());   // 150
    }
}
