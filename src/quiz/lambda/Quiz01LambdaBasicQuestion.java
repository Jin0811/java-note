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
    }
}
