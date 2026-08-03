package quiz.exception;

public class Quiz01TryCatchQuestion {
    public static void main(String[] args) {
        try {
            int number = Integer.parseInt("abc");
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("catch");
        }

        System.out.println("end");

        /*
         * 问题：
         * 1. 代码会不会崩溃？
         * 2. 控制台会输出哪些内容？
         * 3. catch 中的 e 代表什么？
         */
    }
}

