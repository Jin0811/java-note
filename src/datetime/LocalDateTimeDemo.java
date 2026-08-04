package datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

/*
  ===== java.time 三件套：只日期 / 只时间 / 日期+时间 =====

  JS 只有一个 Date，把日期、时间、时区全揉在一起，所以才有那么多坑
  （月份从 0 开始、字符串解析各浏览器不一致……）。
  Java 8 的 java.time 把概念拆开，各管各的：

    LocalDate      只有日期（2026-08-04），无时分秒、无时区
    LocalTime      只有时间（14:30:00），无日期、无时区
    LocalDateTime  日期+时间（2026-08-04T14:30:00），依然无时区

  类比前端生态：
    LocalDate      ≈ dayjs 里只关心"哪天"的日期字符串
    LocalDateTime  ≈ 没有时区概念的 dayjs 对象
    带时区的场景    ≈ 另一个 Demo（TimeZoneDemo），类似 dayjs.tz()

  两个对前端最友好的设计：
    1. 月份从【1】开始！LocalDate.of(1998, 5, 20) 就是 5 月 20 日。
       终于不用像 JS 的 new Date(1998, 4, 20) 那样月份减一了。
    2. 输出自带 ISO-8601 格式（yyyy-MM-dd），toString 直接可读。

  另一个重要特性：java.time 对象全是【不可变】的。
    JS 的 Date 有 setHours/setDate 这种"原地修改"方法；
    LocalDate 没有——所有"修改"都返回新对象（如 date.plusDays(1)），
    类似字符串替换而不是原地改。并发和传参时更安全。
*/

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        // now() 静态工厂：取"当前"，类似 JS 的 new Date()，但按类型各司其职。
        LocalDate today = LocalDate.now();          // 只要日期
        LocalTime nowTime = LocalTime.now();        // 只要时间
        LocalDateTime now = LocalDateTime.now();    // 日期 + 时间（仍无时区）

        System.out.println("today = " + today);     // 2026-08-04
        System.out.println("nowTime = " + nowTime); // 14:30:12.123（ISO 格式）
        System.out.println("now = " + now);         // 2026-08-04T14:30:12.123

        // of(...) 静态工厂：指定年月日构造。注意月份从 1 开始（JS Date 从 0 开始）。
        LocalDate birthday = LocalDate.of(1998, 5, 20);   // 1998 年 5 月 20 日
        System.out.println("birthday = " + birthday);     // 1998-05-20
    }
}
