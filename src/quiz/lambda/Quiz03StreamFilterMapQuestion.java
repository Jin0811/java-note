package quiz.lambda;

import java.util.Arrays;
import java.util.List;

public class Quiz03StreamFilterMapQuestion {
    public static void main(String[] args) {
        List<String> skills = Arrays.asList("Vue", "Java", "Spring");

        skills.stream()
                .filter(skill -> skill.length() > 3)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        /*
         * 问题：
         * 1. 哪些元素会通过 filter？
         * 2. map(String::toUpperCase) 做了什么？
         * 3. stream 会不会修改原来的 skills 集合？
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * JAVA
         * SPRING
         *
         * 问题 1：Java 和 Spring。Vue 长度是 3，不满足 > 3。
         *
         * 问题 2：把通过筛选的字符串转换成大写。
         *
         * 问题 3：不会。Stream 管道产生的是处理过程，
         *     不会直接修改原集合里的字符串。
         */
    }
}
