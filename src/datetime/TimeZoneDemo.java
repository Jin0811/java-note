package datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneDemo {
    public static void main(String[] args) {
        ZonedDateTime shanghaiTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));

        System.out.println("shanghaiTime = " + shanghaiTime);
        System.out.println("utcTime = " + utcTime);
        System.out.println("newYorkTime = " + newYorkTime);
    }
}

