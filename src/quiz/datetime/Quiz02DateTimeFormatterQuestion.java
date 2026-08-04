package quiz.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Quiz02DateTimeFormatterQuestion {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.of(2026, 8, 4, 14, 30, 5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String text = time.format(formatter);
        LocalDateTime parsed = LocalDateTime.parse(text, formatter);

        System.out.println(text);
        System.out.println(parsed);

        /*
         * 问题：
         * 1. format 的作用是什么？
         * 根据formatter进行时间格式化，返回一个字符串
         *
         * 2. parse 的作用是什么？
         * 根据字符串，解析日期/时间对象
         *
         * 3. yyyy 和 MM 为什么大小写不能随便改？
         * 因为java当中规定了格式，MM 和 mm 的含义不同
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：format 的作用是什么？
         * 答：把时间对象按 formatter 模板"格式化"成一个字符串。
         *     方向是 时间对象 → 字符串，对象本身不变（不可变对象）。
         *
         * 问题 2：parse 的作用是什么？
         * 答：parse 是 format 的逆过程：字符串 → 时间对象。
         *     关键要求：字符串必须和模板【严格双向一致】——
         *     字段多少、顺序、分隔符逐字符对上；
         *     且解析出的字段够拼出目标类型（LocalDateTime 至少要有时分）。
         *
         * 问题 3：yyyy 和 MM 为什么大小写不能随便改？
         * 答：不是因为"必须大写"——恰恰相反，这个模板里 mm、ss、dd、yyyy
         *     全是小写。真正的原因是：每个字母是独立符号，大小写决定含义。
         *     改大小写不是"解析不了"，而是变成【另一个字段】：
         *       MM = 月      mm = 分钟      ← 最常见的坑
         *       dd = 日      DD = 一年中的第几天
         *       HH = 24小时制 hh = 12小时制
         *     把 yyyy-MM-dd 错写成 yyyy-mm-dd：编译、运行都不报，
         *     只是月份位置悄悄显示成分钟——静默错误，比报错更危险。
         */
    }
}
