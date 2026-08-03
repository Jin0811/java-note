package quiz.collection;

import java.util.HashMap;
import java.util.Map;

public class Quiz02HashMapQuestion {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Java", 80);
        scores.put("Java", 90);
        scores.put("MySQL", 85);

        System.out.println(scores.get("Java"));
        System.out.println(scores.containsKey("Spring"));
        System.out.println(scores.size());

        /*
         * 问题：
         * 1. 重复 put 同一个 key 会发生什么？
         * 2. containsKey 和 get 的区别是什么？
         * 3. HashMap 的遍历方式有哪些？
         */
    }
}

