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
    }
}
