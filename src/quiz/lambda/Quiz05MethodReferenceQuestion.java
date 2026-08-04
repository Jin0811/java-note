package quiz.lambda;

import java.util.Arrays;
import java.util.List;

public class Quiz05MethodReferenceQuestion {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alex", "Ben");
        names.forEach(System.out::println);

        /*
         * 问题：
         * 1. System.out::println 等价于什么 Lambda？
         * 2. 方法引用适合什么时候使用？
         * 3. 它会改变 forEach 的执行次数吗？
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * Alex
         * Ben
         *
         * 问题 1：等价于 name -> System.out.println(name)。
         *
         * 问题 2：当 Lambda 只是把参数原样交给一个已有方法时，
         *     方法引用更简洁。
         *
         * 问题 3：不会。集合有几个元素，forEach 仍然执行几次。
         */
    }
}
