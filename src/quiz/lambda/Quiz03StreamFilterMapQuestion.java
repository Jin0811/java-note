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
    }
}
