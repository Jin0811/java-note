package lab.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Lab04CollectionSummaryPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：集合遍历、筛选、统计。
         *
         * TODO:
         * 1. 创建 List<Integer> scores，添加多个分数。
         * 2. 统计及格人数。
         * 3. 计算总分和平均分。
         * 4. 找出最高分。
         */
        List<Integer> scores = new ArrayList<>();

        scores.add(20);
        scores.addAll(Arrays.asList(55, 60, 99, 80, 34));

        int passCount = scores.stream().filter(s -> s >= 60).toArray().length;
        System.out.println(passCount);

        int total = scores.stream().reduce(0, Integer::sum);
        System.out.println(total);

        DoubleSummaryStatistics average = scores.stream().mapToDouble(Integer::doubleValue).summaryStatistics();
        System.out.println(average.getSum());
        System.out.println(average.getAverage());
        System.out.println(average.getMax());
    }
}

