package quiz.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz04StreamCollectQuestion {
    public static void main(String[] args) {
        List<Integer> scores = Arrays.asList(50, 60, 80);

        List<Integer> passed = scores.stream()
            .filter(score -> score >= 60)
            .collect(Collectors.toList());

        System.out.println(passed);
        System.out.println(scores);

        /*
         * 问题：
         * 1. passed 中有哪些元素？
         * 大于等于60的元素，即 60 80
         *
         * 2. scores 原集合会变化吗？
         * 不会
         *
         * 3. collect(Collectors.toList()) 的作用是什么？
         * 结束流，收集并返回 List 数据
         */
    }
}
