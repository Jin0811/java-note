package lab.thread;

public class Lab03SleepJoinPractice {
    public static void main(String[] args) throws InterruptedException {
        /*
         * 练习目标：sleep 和 join。
         *
         * TODO:
         * 1. 创建 worker 线程，循环执行 3 次。
         * 2. 每次输出后 sleep 200 毫秒。
         * 3. main 线程调用 worker.join() 等待它结束。
         * 4. 最后输出 "done"。
         */

        Thread worker = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("step " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        worker.start();
        worker.join();
        System.out.println("done");
    }
}
