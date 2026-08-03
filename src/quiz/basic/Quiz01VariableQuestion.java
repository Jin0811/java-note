package quiz.basic;

public class Quiz01VariableQuestion {
    public static void main(String[] args) {
        /*
         * 题目 1：阅读下面的变量声明，回答注释中的问题。
         */
        int age = 28;
        double price = 19.9;
        boolean active = true;
        char level = 'A';
        String name = "Alex";

        System.out.println(name + " / " + age + " / " + price + " / " + active + " / " + level);

        /*
         * 问题：
         * 1. int 和 double 有什么区别？
         * 2. char 和 String 有什么区别？
         * 3. 如果把 int age = 28 改成 int age = 28.5，会发生什么？
         * 4. Java 的 String 首字母为什么是大写？
         */
    }
}

