package lab.thread;

public class Lab01ThreadBasicPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：创建并启动线程。
         *
         * TODO:
         * 1. 创建一个 Thread 对象。
         * 2. 在线程任务中输出当前线程名。
         * 3. 调用 start() 启动线程。
         * 4. 在 main 线程中也输出当前线程名。
         */

        Thread worker = new Thread(() -> {
            System.out.println("worker = " + Thread.currentThread().getName());
        });

        worker.start();
        System.out.println("main = " + Thread.currentThread().getName());
    }
}
