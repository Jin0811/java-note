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

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * 5
         * 6
         *
         * 问题 1：因为 MathAction 只有一个抽象方法 apply，
         *     它是函数式接口，Lambda 正好提供这个方法的实现。
         *
         * 问题 2：输出 5。
         *
         * 问题 3：让编译器检查该接口是否真的只有一个抽象方法。
         *     它不是必须写，但写上更清晰，也能防止后续误加抽象方法。
         */
    }
}

@FunctionalInterface
interface MathAction {
    int apply(int a, int b);
}
