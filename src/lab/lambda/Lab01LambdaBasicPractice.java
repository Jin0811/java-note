package lab.lambda;

import java.util.Arrays;
import java.util.List;

public class Lab01LambdaBasicPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：Lambda 基础写法。
         *
         * TODO:
         * 1. 创建 List<String> skills。
         * 2. 使用 forEach + Lambda 输出每个 skill。
         * 3. 输出时拼接 "learning: "。
         */

        List<String> skills = Arrays.asList("JavaScript", "TypeScript", "Java", "Spring");

        skills.forEach(skill -> System.out.println("learning: " + skill));
    }
}
