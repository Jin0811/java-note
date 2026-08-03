// package 声明当前类所属的包（命名空间），必须和文件所在目录对应：
// src/basic/VariableAndType.java -> package basic。
// 类比 TS：类似模块路径 + 命名空间，用于组织代码、避免类名冲突。
package basic;

public class VariableAndType {
    public static void main(String[] args) {
        // JS/TS: let age: number = 28;
        // Java: 变量声明时必须明确类型。
        int age = 28;
        double salary = 18000.50;
        boolean isFrontendDeveloper = true;
        char level = 'A';
        String name = "Alex";

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("salary = " + salary);
        System.out.println("isFrontendDeveloper = " + isFrontendDeveloper);
        System.out.println("level = " + level);

        // var 可以让 Java 根据右侧值推断局部变量类型，类似 TS 的类型推断。
        var city = "Shanghai";
        var years = 6;

        System.out.println("city = " + city);
        System.out.println("years = " + years);
    }
}

