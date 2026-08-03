// package 声明当前类所属的包（命名空间），必须和文件所在目录对应：
// src/basic/ArrayDemo.java -> package basic。
// 类比 TS：类似模块路径 + 命名空间，用于组织代码、避免类名冲突。
package basic;

public class ArrayDemo {
    public static void main(String[] args) {
        // Java 数组长度固定，声明后不能像 JS Array 那样随意 push。
        String[] names = {"Alex", "Bob", "Cindy"};

        System.out.println("names.length = " + names.length);
        System.out.println("names[0] = " + names[0]);

        names[1] = "Ben";
        System.out.println("names[1] = " + names[1]);

        for (int i = 0; i < names.length; i++) {
            System.out.println("index = " + i + ", name = " + names[i]);
        }

        int[] scores = new int[3];
        scores[0] = 90;
        scores[1] = 85;
        scores[2] = 100;

        for (int score : scores) {
            System.out.println("score = " + score);
        }
    }
}

