package collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        // JS/TS: const skills = ["JS", "TS"];
        // Java: List 更接近 JS Array，可以动态添加和删除元素。
        List<String> skills = new ArrayList<>();

        skills.add("JavaScript");
        skills.add("TypeScript");
        skills.add("Vue");
        skills.add("Java");

        System.out.println("skills = " + skills);
        System.out.println("first = " + skills.get(0));
        System.out.println("size = " + skills.size());

        skills.remove("Vue");
        System.out.println("after remove = " + skills);
    }
}

