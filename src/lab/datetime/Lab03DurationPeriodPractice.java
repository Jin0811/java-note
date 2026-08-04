package lab.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Lab03DurationPeriodPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：Period / Duration。
         *
         * TODO:
         * 1. 使用 Period 计算两个日期相差多少天。
         * 2. 使用 Duration 计算两个时间相差多少分钟。
         * 3. 输出结果。
         */

        LocalDate startDate = LocalDate.of(2026, 8, 1);
        LocalDate endDate = LocalDate.of(2026, 8, 11);
        Period period = Period.between(startDate, endDate);

        LocalDateTime startTime = LocalDateTime.of(2026, 8, 4, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2026, 8, 4, 11, 45);
        Duration duration = Duration.between(startTime, endTime);

        System.out.println("days = " + period.getDays());
        System.out.println("minutes = " + duration.toMinutes());
    }
}
