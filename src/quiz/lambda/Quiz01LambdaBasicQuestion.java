package quiz.lambda;

import java.util.Arrays;
import java.util.List;

public class Quiz01LambdaBasicQuestion {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alex", "Ben", "Cindy");
        names.forEach(name -> System.out.println("Hi " + name));

        /*
         * 问题：
         * 1. Lambda 表达式里的 name 来自哪里？
         * 2. forEach 会执行几次？
         * 3. Java 的 -> 和 JS 的箭头函数有什么相似点？
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * Hi Alex
         * Hi Ben
         * Hi Cindy
         *
         * 问题 1：name 是 forEach 每次遍历传进来的当前元素。
         *
         * 问题 2：3 次，因为集合里有 3 个元素。
         *
         * 问题 3：都能把一段函数逻辑作为参数传递。
         *     区别是 Java Lambda 必须匹配某个函数式接口。
         */
    }
}
