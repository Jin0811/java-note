package lab.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Lab01LocalDateTimePractice {
    public static void main(String[] args) {
        /*
         * 练习目标：LocalDate / LocalTime / LocalDateTime。
         *
         * TODO:
         * 1. 获取今天的日期。
         * 2. 获取当前时间。
         * 3. 创建一个固定的学习开始时间。
         * 4. 分别输出这些值。
         */

        LocalDate today = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        LocalDateTime startAt = LocalDateTime.of(2026, 8, 4, 9, 30);

        System.out.println("today = " + today);
        System.out.println("nowTime = " + nowTime);
        System.out.println("startAt = " + startAt);
    }
}
