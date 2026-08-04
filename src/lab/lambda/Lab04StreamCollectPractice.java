package lab.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lab04StreamCollectPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：Stream collect 收集结果。
         *
         * TODO:
         * 1. 创建分数集合。
         * 2. 筛选出及格分数。
         * 3. 使用 collect(Collectors.toList()) 收集成新 List。
         * 4. 输出新集合。
         */

        List<Integer> scores = Arrays.asList(45, 60, 72, 89, 30);

        List<Integer> passedScores = scores.stream()
                .filter(score -> score >= 60)
                .collect(Collectors.toList());

        System.out.println(passedScores);
    }
}
