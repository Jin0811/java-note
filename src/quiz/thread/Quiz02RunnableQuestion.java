package quiz.thread;

public class Quiz02RunnableQuestion {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println(Thread.currentThread().getName());

        new Thread(task, "A").start();
        new Thread(task, "B").start();

        /*
         * 问题：
         * 1. Runnable 表示线程还是任务？
         * 2. 同一个 Runnable 能不能交给多个 Thread 执行？
         * 3. A 和 B 的输出顺序固定吗？
         */
    }
}
