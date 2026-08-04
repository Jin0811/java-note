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
         * try catch finally
         *
         * 2. finally 一般用来做什么？
         * finally会始终执行，一般用于收尾
         *
         * 3. 如果没有 catch，finally 还会执行吗？
         * 会执行，finally会始终执行
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：输出顺序是什么？
         * 答：try -> catch -> finally。
         *     执行流程：
         *       打印 "try" → 10/0 抛 ArithmeticException
         *       → result 的打印被跳过（抛异常点之后全跳过）
         *       → 进入 catch，打印 "catch"
         *       → catch 结束后，finally 必然执行，打印 "finally"。
         *
         * 问题 2：finally 一般用来做什么？
         * 答：放"无论成功失败都必须执行的收尾工作"。典型场景：
         *       · 关闭资源：文件流、数据库连接、网络连接
         *       · 释放锁：synchronized/Lock 的解锁
         *       · 清理临时状态
         *     因为这些操作"漏了就会出问题"（资源泄漏、死锁），
         *     所以必须放在 finally 里保证一定执行，而不是放在 try/catch 某一分支里。
         *     （补充：Java 7+ 的 try-with-resources 能自动关闭资源，
         *       很多场景可以替代手写 finally，后面会遇到。）
         *
         * 问题 3：如果没有 catch，finally 还会执行吗？
         * 答：会执行。catch 是可选的，try-finally 没有 catch 也合法。
         *     此时若 try 里抛异常，执行顺序是：
         *       try 抛异常 → 先执行 finally → 异常再继续向上冒泡。
         *     finally"几乎总是执行"，仅有的例外：
         *       System.exit() 主动退出 JVM、JVM/操作系统崩溃、线程被强制终止。
         */
    }
}

