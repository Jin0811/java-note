package lab.lambda;

import java.util.ArrayList;
import java.util.List;

public class Lab05MethodReferencePractice {
    public static void main(String[] args) {
        /*
         * 练习目标：方法引用。
         *
         * TODO:
         * 1. 创建 names 集合。
         * 2. 先用 Lambda 输出。
         * 3. 再改成 System.out::println 方法引用。
         */

        List<String> names = new ArrayList<>(List.of("张三", "李四", "王五", "赵六"));
        names.forEach(i -> System.out.println(i));
        names.forEach(System.out::println);
    }
}
