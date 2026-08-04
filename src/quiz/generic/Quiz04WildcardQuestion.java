package quiz.generic;

import java.util.Arrays;
import java.util.List;

public class Quiz04WildcardQuestion {
    public static void main(String[] args) {
        List<Integer> ages = Arrays.asList(18, 20, 28);
        printNumbers(ages);

        /*
         * 问题：
         * 1. List<Integer> 能不能直接赋给 List<Number>？
         * 2. ? extends Number 表示什么？
         * 3. 为什么 printNumbers 里不适合 add 新元素？
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * 18
         * 20
         * 28
         *
         * 问题 1：不能。Java 泛型默认是不变的，List<Integer> 不是 List<Number>。
         *
         * 问题 2：表示某个未知类型，但它一定是 Number 或 Number 的子类。
         *     所以 List<Integer>、List<Double> 都能传入。
         *
         * 问题 3：因为编译器不知道真实集合到底是 List<Integer> 还是 List<Double>。
         *     贸然 add 可能把错误类型塞进去，所以 ? extends 更适合读取。
         */
    }

    static void printNumbers(List<? extends Number> numbers) {
        for (Number number : numbers) {
            System.out.println(number);
        }
    }
}
