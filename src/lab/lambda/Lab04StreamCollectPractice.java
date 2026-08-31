package lab.lambda;

import java.util.ArrayList;
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
        List<Integer> scores = new ArrayList<>(List.of(43, 56, 60, 88, 90));

        // java8+
        List<Integer> resultList1 = scores.stream().filter(i -> i >= 60).collect(Collectors.toList());
        System.out.println(resultList1);

        // java16+
        List<Integer> resultList2 = scores.stream().filter(i -> i >= 60).toList();
        System.out.println(resultList2);
    }
}
