package quiz.lambda;

public class Quiz02FunctionalInterfaceQuestion {
    public static void main(String[] args) {
        MathAction add = (a, b) -> a + b;
        MathAction multiply = (a, b) -> a * b;

        System.out.println(add.apply(2, 3));
        System.out.println(multiply.apply(2, 3));

        /*
         * 问题：
         * 1. MathAction 为什么能用 Lambda 赋值？
         * 因为 MathAction 是一个函数式接口，只有一个抽象方法 apply。
         *
         * 2. add.apply(2, 3) 输出多少？
         * 输出值为 5
         *
         * 3. @FunctionalInterface 的作用是什么？
         * 这个注解用于表明 MathAction 是函数式接口，不是使用 Lambda 的必要条件。
         * 加上注解后，编译器会检查接口只能有一个抽象方法。
         */
        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：MathAction 为什么能用 Lambda 赋值？
         * 答：MathAction 是函数式接口，只有一个抽象方法 apply(int, int)。
         *     这个方法的参数列表和返回值决定了 Lambda 的形状：接收两个 int，返回一个 int。
         *     因此 (a, b) -> a + b 可以作为 MathAction 的实现。
         *
         * 问题 2：add.apply(2, 3) 输出多少？
         * 答：输出 5，因为 add 对应的 Lambda 方法体是 a + b。
         *     程序随后调用 multiply.apply(2, 3)，输出 6，所以完整输出顺序是：
         *     5
         *     6
         *
         * 问题 3：@FunctionalInterface 的作用是什么？
         * 答：它是编译器检查和代码说明注解，用来明确表示接口应该是函数式接口。
         *     如果以后增加第二个抽象方法，编译器会报错，防止接口不再适合 Lambda。
         *     这个注解本身不是 Lambda 运行所必需的；只要接口仍然只有一个抽象方法，
         *     即使去掉注解也可以使用 Lambda。default 方法和 static 方法不算抽象方法。
         */
    }
}

@FunctionalInterface
interface MathAction {
    int apply(int a, int b);
}
