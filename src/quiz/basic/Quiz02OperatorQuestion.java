package quiz.basic;

public class Quiz02OperatorQuestion {
    public static void main(String[] args) {
        /*
         * 题目 2：先不要运行，先判断每一行输出结果，再运行验证。
         */
        int a = 10;
        int b = 3;

        System.out.println(a / b);
        System.out.println(a * 1.0 / b);
        System.out.println(a % b);
        System.out.println(a > b);
        System.out.println(a > 5 && b > 5);
        System.out.println(a > 5 || b > 5);

        /*
         * 问题：
         * 1. a / b 为什么不是小数？
         * 2. a * 1.0 / b 的结果类型是什么？
         * 3. && 和 || 的区别是什么？
         */
    }
}

