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
    }
}
