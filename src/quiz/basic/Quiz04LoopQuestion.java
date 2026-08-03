package quiz.basic;

public class Quiz04LoopQuestion {
    public static void main(String[] args) {
        /*
         * 题目 4：先判断输出，再运行验证。
         */
        int sum = 0;

        for (int i = 1; i <= 5; i++) {
            sum += i;
        }

        System.out.println("sum = " + sum);

        int count = 3;
        while (count > 0) {
            System.out.println("count = " + count);
            count--;
        }

        /*
         * 问题：
         * 1. for 循环结束后 sum 是多少？
         * 2. while 循环会执行几次？
         * 3. 如果忘记 count--，会发生什么？
         */
    }
}

