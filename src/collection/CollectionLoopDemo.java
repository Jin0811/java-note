package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionLoopDemo {
    public static void main(String[] args) {
        List<String> skills = new ArrayList<>();
        skills.add("JavaScript");
        skills.add("TypeScript");
        skills.add("Java");

        for (String skill : skills) {
            System.out.println("skill = " + skill);
        }

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Java", 90);
        scores.put("MySQL", 85);
        scores.put("Spring", 88);

        // ===== 遍历 Map 写法一：entrySet()（推荐）=====
        // entrySet() 返回 Set<Map.Entry<String, Integer>>，即"所有键值对的集合"。
        // Map.Entry 是 Map 里的嵌套接口，表示"一个 key-value 对"，
        // 类比 JS 的 for (const [key, value] of scores.entries())——
        // JS 用数组解构拿键值，Java 用 getKey()/getValue() 拿。
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " score = " + entry.getValue());
        }

        // ===== 写法二：keySet() + get() =====
        // 先遍历所有 key，再拿 key 去查 value。功能一样，但每个元素多一次哈希查找，略慢。
        // 适合"只需要 key，偶尔才查 value"的场景。
        for (String key : scores.keySet()) {
            System.out.println(key + " score = " + scores.get(key));
        }

        // ===== 写法三：forEach + lambda（Java 8+，现代代码里最常见）=====
        // 最简洁：一行拿到 key 和 value。(key, value) -> ... 是 lambda 表达式，
        // 类比 JS 的 scores.forEach((value, key) => { ... })。
        // 注意顺序：Java 是 (key, value)，JS 的 forEach 是 (value, key)，别搞混。
        scores.forEach((key, value) -> System.out.println(key + " score = " + value));

        // ===== 只遍历值：values() =====
        // 不关心 key、只想要所有 value 时用。
        for (Integer value : scores.values()) {
            System.out.println("some score = " + value);
        }
    }
}

