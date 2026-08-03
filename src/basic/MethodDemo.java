// package 声明当前类所属的包（命名空间），必须和文件所在目录对应：
// src/basic/MethodDemo.java -> package basic。
// 类比 TS：类似模块路径 + 命名空间，用于组织代码、避免类名冲突。
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

