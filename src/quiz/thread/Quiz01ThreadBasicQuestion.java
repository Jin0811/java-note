package quiz.thread;

public class Quiz01ThreadBasicQuestion {
    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            System.out.println("worker");
        });

        worker.start();
        System.out.println("main");

        /*
         * 问题：
         * 1. start() 和 run() 有什么区别？
         * 2. "worker" 和 "main" 的输出顺序一定固定吗？
         * 3. Thread.currentThread().getName() 能拿到什么？
         */

        /*
         * ========== 标准答案 ==========
         *
         * 输出包含 worker 和 main，但顺序不保证固定。
         *
         * 问题 1：start() 会启动一条新线程，再由新线程执行 run；
         *     run() 只是普通方法调用，不会创建新线程。
         *
         * 问题 2：不一定。线程调度由 JVM 和操作系统共同决定。
         *
         * 问题 3：拿到当前正在执行这行代码的线程名称。
         */
    }
}
