package collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // JS/TS: const user = { name: "Alex", age: 28 };
        // Java: Map 用 key/value 保存数据。
        Map<String, String> user = new HashMap<>();

        user.put("name", "Alex");
        user.put("role", "Frontend Engineer");
        user.put("target", "Java Backend Engineer");

        System.out.println("user = " + user);
        System.out.println("name = " + user.get("name"));
        System.out.println("has role = " + user.containsKey("role"));

        user.put("role", "Full Stack Engineer");
        System.out.println("updated user = " + user);
    }
}

