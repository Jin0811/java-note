package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        // Set 的特点是元素不重复，适合做去重。
        Set<String> tags = new HashSet<>();

        tags.add("java");
        tags.add("spring");
        tags.add("mysql");
        tags.add("java");

        System.out.println("tags = " + tags);
        System.out.println("size = " + tags.size());
        System.out.println("contains spring = " + tags.contains("spring"));
    }
}

