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
    }
}
