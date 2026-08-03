package quiz.exception;

public class Quiz02FinallyQuestion {
    public static void main(String[] args) {
        try {
            System.out.println("try");
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }

        /*
         * 问题：
         * 1. 输出顺序是什么？
         * 2. finally 一般用来做什么？
         * 3. 如果没有 catch，finally 还会执行吗？
         */
    }
}

