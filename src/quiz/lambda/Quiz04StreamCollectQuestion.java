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
         * 2. scores 原集合会变化吗？
         * 3. collect(Collectors.toList()) 的作用是什么？
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * [60, 80]
         * [50, 60, 80]
         *
         * 问题 1：60 和 80。
         *
         * 问题 2：不会，filter 得到的是新的 Stream 结果。
         *
         * 问题 3：把 Stream 中剩下的元素收集成一个 List。
         */
    }
}
