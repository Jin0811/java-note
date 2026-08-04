package quiz.basic;

public class Quiz04LoopQuestion {
    public static void main(String[] args) {
        /*
         * 题目 4：先判断输出，再运行验证。
         * 这里是求1到5的和，即 1 + 2 + 3 + 4 + 5 = 15
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
         * 这里是求1到5的和，即 1 + 2 + 3 + 4 + 5 = 15
         *
         * 2. while 循环会执行几次？
         * 3次，分别为 3 2 1
         *
         * 3. 如果忘记 count--，会发生什么？
         * 会无限循环，因为缺少退出while的条件
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：for 循环结束后 sum 是多少？
         * 答：15。
         *     循环从 i=1 到 i=5，逐次执行 sum += i：
         *       0+1=1 → 1+2=3 → 3+3=6 → 6+4=10 → 10+5=15。
         *     循环结束时 i 自增到 6（不满足 i<=5 才退出），但 sum 保持 15。
         *
         * 问题 2：while 循环会执行几次？
         * 答：3 次，依次输出 count = 3、count = 2、count = 1。
         *     每轮先打印当前 count，再 count--：
         *       3 > 0 成立 → 打印 3 → count 变 2
         *       2 > 0 成立 → 打印 2 → count 变 1
         *       1 > 0 成立 → 打印 1 → count 变 0
         *       0 > 0 不成立 → 退出。
         *     共 3 次。
         *
         * 问题 3：如果忘记 count--，会发生什么？
         * 答：死循环（无限循环）。
         *     count 永远停在 3，条件 count > 0 恒为 true，循环永不退出，
         *     控制台会无限打印 count = 3，只能强制终止程序。
         *     教训：while 循环体内必须包含"让条件趋向 false"的语句，
         *     否则就是死循环。
         */
    }
}

