package lab.datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Lab04TimeZonePractice {
    public static void main(String[] args) {
        /*
         * 练习目标：时区。
         *
         * TODO:
         * 1. 获取 Asia/Shanghai 当前时间。
         * 2. 获取 UTC 当前时间。
         * 3. 获取 America/New_York 当前时间。
         * 4. 输出三个 ZonedDateTime。
         */
        ZonedDateTime shanghaiTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));

        System.out.println("shanghaiTime = " + shanghaiTime);
        System.out.println("utcTime = " + utcTime);
        System.out.println("newYorkTime = " + newYorkTime);
    }
}
