package lambda;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;

        System.out.println("add = " + add.calculate(10, 20));
        System.out.println("multiply = " + multiply.calculate(10, 20));
    }
}

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

