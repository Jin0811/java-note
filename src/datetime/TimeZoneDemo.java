package datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/*
  ===== ZonedDateTime：带时区的日期时间 =====

  前面三个 Local*（LocalDate/LocalTime/LocalDateTime）都【没有时区】，
  它们只描述"墙上的日历和钟"。一旦涉及"同一个瞬间在不同地区是几点"，
  就必须上 ZonedDateTime —— 相当于 LocalDateTime + 时区。

  类比前端：
    LocalDateTime                ≈ dayjs 对象（无时区概念）
    ZonedDateTime                ≈ dayjs.tz(...)（dayjs 的 timezone 插件）
    ZoneId.of("Asia/Shanghai")   ≈ Intl.DateTimeFormat 里的 timeZone: "Asia/Shanghai"

  ZoneId 用的是 IANA 时区名（"大陆/城市"格式），如 Asia/Shanghai、
  America/New_York、UTC。好处是该名字自带"夏令时规则"，
  Java 自动帮你算偏移，不用手写 +8 / -5 这种硬编码。

  关键认知：ZonedDateTime.now(ZoneId.of("UTC")) 和 now(Asia/Shanghai)
  拿到的是【同一个物理瞬间】，只是"用不同时区的钟去读"它，
  所以打印出来的时分不同、但指向同一刻。这正是时区的本质。

  什么时候该用一个"无时区"的 LocalDateTime 存起来、什么时候必须带时区？
  经验法则：跨时区展示/换算、存库、跨服务传输 → 用 ZonedDateTime 或 UTC；
  只在本地展示"日历/钟点" → Local* 就够。
*/

public class TimeZoneDemo {
    public static void main(String[] args) {
        // 同一个"现在"，分别用三个时区的钟去读。
        ZonedDateTime shanghaiTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));

        // 三行的"瞬间"相同，打印出的时间不同；末尾的 +08:00 / Z / -04:00 是偏移量。
        System.out.println("shanghaiTime = " + shanghaiTime);
        System.out.println("utcTime = " + utcTime);
        System.out.println("newYorkTime = " + newYorkTime);
    }
}
