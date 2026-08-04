package lab.generic;

import java.util.Arrays;
import java.util.List;

public class Lab04WildcardPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：通配符 ? extends。
         *
         * TODO:
         * 1. 创建 List<Integer> 和 List<Double>。
         * 2. 实现 printNumbers 方法，同时接收这两种集合。
         * 3. 在方法中遍历输出元素。
         */

        List<Integer> intNumbers = Arrays.asList(1, 2, 3);
        List<Double> doubleNumbers = Arrays.asList(1.5, 2.5, 3.5);

        printNumbers(intNumbers);
        printNumbers(doubleNumbers);
    }

    static void printNumbers(List<? extends Number> numbers) {
        for (Number number : numbers) {
            System.out.println("number = " + number);
        }
    }
}
