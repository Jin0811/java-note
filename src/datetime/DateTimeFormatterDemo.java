package datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
  ===== DateTimeFormatter：格式化与解析（Java 内置的 dayjs）=====

  JS 的 Date 几乎没有好用的内置格式化（要靠 toLocaleString 或 dayjs），
  Java 把"时间 ↔ 字符串"的互转做成了内置标准能力：

    时间 → 字符串：now.format(formatter)      ≈ dayjs().format("YYYY-MM-DD HH:mm:ss")
    字符串 → 时间：LocalDateTime.parse(s, formatter) ≈ dayjs("2026-08-03 14:30:00", fmt)

  模式字母（和 dayjs/moment 很像，但大小写敏感，是最常见的坑）：
    yyyy 年    MM 月    dd 日
    HH 时(24h) mm 分钟  ss 秒
    ⚠️ MM = 月，mm = 分钟！写成 yyyy-mm-dd 就错了。
    ⚠️ dd = 日，DD 是"一年中的第几天"，也会错。

  注意和 JS 的一个差别：
    JS 的 new Date("2026-08-03 14:30:00") 能直接吃常见格式；
    Java 的 parse 默认只吃标准 ISO 格式（2026-08-03T14:30:00），
    自定义格式必须把 formatter 一起传进去，两边模板必须严格一致。
*/

public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        // ofPattern：声明"模板"，对象本身不含任何时间值（类似模板字符串）。
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 时间 → 字符串：按模板输出。
        String formatted = now.format(formatter);
        // 字符串 → 时间：必须用同一个 formatter 反向解析，格式对不上会抛 DateTimeParseException。
        LocalDateTime parsed = LocalDateTime.parse("2026-08-03 14:30:00", formatter);

        System.out.println("formatted = " + formatted);  // 2026-08-04 14:30:12
        System.out.println("parsed = " + parsed);        // 2026-08-03T14:30（toString 回到 ISO 格式）
    }
}
