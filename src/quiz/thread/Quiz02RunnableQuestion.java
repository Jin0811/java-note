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

        /*
         * ========== 标准答案 ==========
         *
         * 输出包含 A 和 B，但顺序不保证固定。
         *
         * 问题 1：Runnable 表示任务，Thread 才表示执行任务的线程。
         *
         * 问题 2：可以。同一个任务对象可以被多个线程复用。
         *
         * 问题 3：不固定，多线程输出顺序通常不能依赖。
         */
    }
}
