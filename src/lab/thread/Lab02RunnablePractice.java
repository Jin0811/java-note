package lab.thread;

public class Lab02RunnablePractice {
    public static void main(String[] args) {
        /*
         * 练习目标：Runnable 任务复用。
         *
         * TODO:
         * 1. 创建 Runnable 任务，循环输出 1 到 3。
         * 2. 用同一个任务创建两个 Thread。
         * 3. 给两个线程设置不同名称。
         * 4. 启动两个线程。
         */

        Runnable task = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
            }
        };

        new Thread(task, "task-a").start();
        new Thread(task, "task-b").start();
    }
}
