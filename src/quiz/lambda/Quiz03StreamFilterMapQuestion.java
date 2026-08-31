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
         * Java 和 Spring，因为它们的字符串长度大于 3。
         *
         * 2. map(String::toUpperCase) 做了什么？
         * 对每个通过筛选的字符串调用 toUpperCase()，返回转换后的大写字符串。
         *
         * 3. stream 会不会修改原来的 skills 集合？
         * 不会
         */
        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：哪些元素会通过 filter？
         * 答：filter 的条件是 skill.length() > 3：
         *     Vue 长度为 3，不满足条件；Java 长度为 4，满足条件；
         *     Spring 长度为 6，满足条件。因此 Java 和 Spring 会通过筛选。
         *
         * 问题 2：map(String::toUpperCase) 做了什么？
         * 答：map 会把 Stream 中的每个元素转换成另一个元素。
         *     String::toUpperCase 是方法引用，等价于 skill -> skill.toUpperCase()。
         *     所以 Java 会转换为 JAVA，Spring 会转换为 SPRING。
         *
         * 问题 3：Stream 会不会修改原来的 skills 集合？
         * 答：不会。filter 和 map 会产生后续处理结果，forEach 这里只负责输出，
         *     没有调用 skills.add()、set() 或 remove() 修改原集合。
         *     原集合仍然是 [Vue, Java, Spring]，最终输出是：
         *     JAVA
         *     SPRING
         */
    }
}
