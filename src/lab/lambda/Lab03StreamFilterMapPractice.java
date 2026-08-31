package lab.lambda;

import java.util.ArrayList;
import java.util.List;

public class Lab03StreamFilterMapPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：Stream 的 filter / map / forEach。
         *
         * TODO:
         * 1. 创建 skills 集合。
         * 2. 筛选长度大于 4 的技能。
         * 3. 转成大写后输出。
         */
        List<String> skills = new ArrayList<>(List.of("JavaScript", "TypeScript", "Java", "Spring"));
        skills.stream()
            .filter(item -> item.length() > 4)
            .map(String::toUpperCase)
            .forEach(System.out::println);
    }
}
