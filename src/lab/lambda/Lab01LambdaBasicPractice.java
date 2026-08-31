package lab.lambda;

import java.util.ArrayList;
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

        List<String> skills = new ArrayList<>();
        skills.add("唱歌");
        skills.add("跳舞");
        skills.add("篮球");
        skills.forEach(skill -> System.out.println("learning: " + skill));
    }
}
