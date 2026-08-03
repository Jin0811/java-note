package quiz.exception;

public class Quiz03ThrowQuestion {
    public static void main(String[] args) {
        try {
            checkAge(16);
            System.out.println("ok");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        /*
         * 问题：
         * 1. checkAge(16) 会发生什么？
         * 2. "ok" 会不会输出？
         * 3. throw 和 throws 有什么区别？
         */
    }

    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("age must be greater than or equal to 18");
        }
    }
}

