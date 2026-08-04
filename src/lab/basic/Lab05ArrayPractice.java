package lab.basic;

import java.util.Arrays;

public class Lab05ArrayPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：数组声明、数组访问、数组遍历。
         *
         * TODO:
         * 1. 创建 int[] scores，包含 5 个分数。
         * 2. 输出数组长度。
         * 3. 输出第一个元素和最后一个元素。
         * 4. 使用 for 循环计算总分。
         * 5. 计算并输出平均分。
         * 6. 找出并输出最高分。
         */

        int[] scores = {20, 56, 82, 23, 45};
        System.out.println(scores.length);
        System.out.println(scores[0]);
        System.out.println(scores[scores.length - 1]);

        int sum = 0;
        for (int score : scores) {
            sum = sum + score;
        }
        System.out.println("sum = " + sum);

        System.out.println("平均分 = " + (sum / scores.length));
        System.out.println("平均分带小数 = " + ((double) sum / scores.length));

        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        System.out.println("最高分 = " + max);
    }
}

