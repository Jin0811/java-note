package lab.collection;

import java.util.HashMap;
import java.util.Map;

public class Lab02HashMapPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：HashMap 键值对操作。
         *
         * TODO:
         * 1. 创建 Map<String, String> user。
         * 2. 放入 name、role、target 三个 key。
         * 3. 根据 name 获取值并输出。
         * 4. 修改 role 的值。
         * 5. 遍历输出所有 key 和 value。
         */
        Map<String, String> user = new HashMap<>();

        user.put("name", "Tom");
        user.put("role", "管理员");
        user.put("target", "111");

        System.out.println(user.get("name"));

        user.put("role", "游客");

        System.out.println(user);

        for (Map.Entry<String, String> entry : user.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
    }
}

