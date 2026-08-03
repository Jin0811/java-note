package generic;

import java.util.ArrayList;
import java.util.List;

public class WildcardDemo {
    public static void main(String[] args) {
        List<Integer> intNumbers = new ArrayList<>();
        intNumbers.add(1);
        intNumbers.add(2);
        intNumbers.add(3);

        List<Double> doubleNumbers = new ArrayList<>();
        doubleNumbers.add(1.5);
        doubleNumbers.add(2.5);

        printNumbers(intNumbers);
        printNumbers(doubleNumbers);
    }

    // ? extends Number 表示可以接收 Number 或 Number 子类的 List。
    static void printNumbers(List<? extends Number> numbers) {
        for (Number number : numbers) {
            System.out.println("number = " + number);
        }
    }
}

