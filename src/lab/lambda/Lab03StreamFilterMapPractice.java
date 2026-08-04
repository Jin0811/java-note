package lab.lambda;

import java.util.Arrays;
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

        List<String> skills = Arrays.asList("JS", "Vue", "Java", "Spring", "MySQL");

        skills.stream()
                .filter(skill -> skill.length() > 4)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
