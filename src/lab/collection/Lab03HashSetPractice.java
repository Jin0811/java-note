package lab.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lab03HashSetPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：HashSet 去重。
         *
         * TODO:
         * 1. 创建 Set<String> tags。
         * 2. 添加 java、spring、mysql、java。
         * 3. 输出 tags 和 size。
         * 4. 判断 tags 中是否包含 spring。
         * 5. 删除 mysql 后再次输出。
         */
        Set<String> tags = new HashSet<>();

        tags.add("java");
        tags.addAll(Arrays.asList("spring", "mysql", "java"));

        System.out.println(tags);
        System.out.println(tags.size());
        System.out.println(tags.contains("spring"));

        tags.remove("mysql");
        System.out.println(tags);
    }
}

