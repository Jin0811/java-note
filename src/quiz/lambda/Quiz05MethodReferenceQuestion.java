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
         * name -> System.out.println(name)
         *
         * 2. 方法引用适合什么时候使用？
         * 当 Lambda 只是直接调用一个已经存在的方法，并且方法签名匹配时使用。
         * 如果需要额外处理参数，通常使用 Lambda；也可以把处理逻辑单独写成方法后再引用。
         *
         * 3. 它会改变 forEach 的执行次数吗？
         * 不会，仍然会针对 names 中的每个元素执行一次。
         */
        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：System.out::println 等价于什么 Lambda？
         * 答：在本题的上下文中等价于：
         *     name -> System.out.println(name)
         *     names.forEach() 需要一个接收 String 且不返回结果的 Consumer，
         *     编译器会根据这个目标类型确定引用的是 println(String) 方法。
         *
         * 问题 2：方法引用适合什么时候使用？
         * 答：当 Lambda 的方法体只是直接调用一个已有方法，且参数和返回值能够匹配时，
         *     方法引用可以让代码更简洁。例如：
         *     name -> System.out.println(name) 可以简化为 System.out::println。
         *     如果需要拼接字符串、判断条件或调用多个方法，通常使用普通 Lambda 更清晰；
         *     也可以先把复杂逻辑封装成一个方法，再使用方法引用。
         *
         * 问题 3：方法引用会改变 forEach 的执行次数吗？
         * 答：不会。方法引用只是 Lambda 的简化写法，不会改变 forEach 的遍历逻辑。
         *     names 有 Alex 和 Ben 两个元素，因此 println 会被调用 2 次，输出：
         *     Alex
         *     Ben
         */
    }
}
