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
         * 来自于 names 列表，当 Lambda 表达式执行的时候，每一次执行都会从 names 当中取出一个数据，传递给 Lambda 表达式
         *
         * 2. forEach 会执行几次？
         * forEach会执行1次，其中的 Lambda 表达式会执行3次，也就是names的长度次数
         *
         * 3. Java 的 -> 和 JS 的箭头函数有什么相似点？
         * Java 的 Lambda 的形式为 ->
         * JS 里面的箭头函数形式为 =>
         * 表现形式类似，方法如map、forEach、filter也类似
         */
    }
}
