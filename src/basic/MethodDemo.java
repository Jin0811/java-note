package basic;

public class MethodDemo {
    public static void main(String[] args) {
        sayHello("Alex");

        int sum = add(10, 20);
        System.out.println("sum = " + sum);

        boolean passed = isPassed(86);
        System.out.println("passed = " + passed);
    }

    // JS/TS: function sayHello(name: string): void {}
    // Java: 访问修饰符 static 返回值类型 方法名(参数类型 参数名) {}
    public static void sayHello(String name) {
        System.out.println("Hello, " + name);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static boolean isPassed(int score) {
        return score >= 60;
    }
}

