package quiz.thread;

public class Quiz03SleepJoinQuestion {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                Thread.sleep(100);
                System.out.println("worker done");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        worker.start();
        worker.join();
        System.out.println("main done");

        /*
         * 问题：
         * 1. sleep(100) 暂停的是哪条线程？
         * 2. join() 的作用是什么？
         * 3. 本题输出顺序是否固定？
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出顺序固定：
         * worker done
         * main done
         *
         * 问题 1：暂停执行 sleep 的当前线程，也就是 worker 线程。
         *
         * 问题 2：main 线程等待 worker 线程执行结束后再继续往下走。
         *
         * 问题 3：固定。因为 worker.join() 保证 main done 在 worker 结束之后输出。
         */
    }
}
