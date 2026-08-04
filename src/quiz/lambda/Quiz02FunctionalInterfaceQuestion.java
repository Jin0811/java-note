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
         * 2. add.apply(2, 3) 输出多少？
         * 3. @FunctionalInterface 的作用是什么？
         */
    }
}

@FunctionalInterface
interface MathAction {
    int apply(int a, int b);
}
