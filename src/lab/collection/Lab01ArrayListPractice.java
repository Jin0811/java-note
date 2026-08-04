package lab.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab01ArrayListPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：ArrayList 增删改查。
         *
         * TODO:
         * 1. 创建 List<String> skills。
         * 2. 添加 JavaScript、TypeScript、Java。
         * 3. 输出第一个元素和集合长度。
         * 4. 删除 TypeScript。
         * 5. 遍历输出所有元素。
         */
        // 面向接口声明：List 是接口，ArrayList 是实现类（见 ArrayListDemo）
        List<String> skills = new ArrayList<>();
        skills.add("JavaScript");   // add = JS 的 push，追加到末尾
        // addAll：一次性批量添加多个元素。
        // Arrays.asList(...) 把几个值包装成 List；Java 9+ 也可用 List.of(...)，
        // 但 List.of 创建的是【不可变】列表（不能 add/remove），注意区分。
        skills.addAll(Arrays.asList("TypeScript", "Java"));

        System.out.println(skills.get(0));    // get(i)：按下标取，下标从 0 开始
        System.out.println(skills.size());    // size()：元素个数（是方法，不是 .length 属性）

        // ===== remove 是"重载"方法：按值删 和 按下标删 =====
        skills.remove("TypeScript");   // remove(Object)：按【值】删除
        // skills.remove(1);           // remove(int)：按【下标】删除第 2 个元素
        // ⚠️ 著名陷阱：List<Integer> 里 remove(1) 删的是"下标 1"，不是"值为 1"！
        //    因为编译器优先匹配 remove(int) 重载。想按值删要写成：
        //    nums.remove(Integer.valueOf(10));

        System.out.println(skills);    // List 重写了 toString()，直接打印出 [元素, 元素]

        // 增强 for 循环遍历（类似 JS 的 for...of）
        for (String str : skills) {
            System.out.println(str);
        }
    }
}

