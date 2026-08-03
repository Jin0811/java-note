package quiz.collection;

import java.util.HashSet;
import java.util.Set;

public class Quiz03HashSetQuestion {
    public static void main(String[] args) {
        Set<String> tags = new HashSet<>();
        tags.add("java");
        tags.add("spring");
        tags.add("java");

        System.out.println(tags);
        System.out.println(tags.size());

        /*
         * 问题：
         * 1. 为什么 size 不是 3？
         * 2. HashSet 是否保证元素顺序？
         * 3. 什么场景适合使用 Set？
         */
    }
}

