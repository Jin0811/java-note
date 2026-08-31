package lab.lambda;

public class Lab02FunctionalInterfacePractice {
    public static void main(String[] args) {
        /*
         * 练习目标：函数式接口。
         *
         * TODO:
         * 1. 定义 TextFormatter 函数式接口。
         * 2. 使用 Lambda 创建 upper 和 prefix 两个实现。
         * 3. 调用 format 方法观察结果。
         */

        TextFormatter upper = (text) -> text.toUpperCase();
        TextFormatter prefix = (text) -> "前缀" + text;

        System.out.println("upper = " + upper.format("abc"));
        System.out.println("prefix = " + prefix.format("abc"));
    }
}

@FunctionalInterface
interface TextFormatter {
    String format(String text);
}
