package lab.datetime;

import java.time.*;

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
        LocalDate startDate = LocalDate.of(2026, 7, 10);
        LocalDate endDate = LocalDate.of(2026, 8, 20);
        Period period = Period.between(startDate, endDate);
        System.out.println("年份相差：" + period.getYears());
        System.out.println("月份相差：" + period.getMonths());
        System.out.println("天数相差：" + period.getMonths());

        LocalTime startTime = LocalTime.of(11, 30);
        LocalTime endTime = LocalTime.of(14, 50);
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("小时相差：" + duration.toHours());
        System.out.println("分钟相差：" + duration.toMinutes());
    }
}
