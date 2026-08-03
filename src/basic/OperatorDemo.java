// package 声明当前类所属的包（命名空间），必须和文件所在目录对应：
// src/basic/OperatorDemo.java -> package basic。
// 类比 TS：类似模块路径 + 命名空间，用于组织代码、避免类名冲突。
package basic;

public class OperatorDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        // 注意：两个 int 相除，结果仍然是 int，小数部分会被丢弃。
        double result = a / b;
        double accurateResult = a * 1.0 / b;

        System.out.println("result = " + result);
        System.out.println("accurateResult = " + accurateResult);

        boolean isAdult = true;
        boolean hasPermission = false;

        System.out.println("isAdult && hasPermission = " + (isAdult && hasPermission));
        System.out.println("isAdult || hasPermission = " + (isAdult || hasPermission));
        System.out.println("!isAdult = " + (!isAdult));
    }
}

