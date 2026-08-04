package quiz.thread;

public class Quiz04SynchronizedQuestion {
    public static void main(String[] args) throws InterruptedException {
        QuizCounter counter = new QuizCounter();

        Thread t1 = new Thread(() -> add(counter));
        Thread t2 = new Thread(() -> add(counter));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter.getCount());

        /*
         * 问题：
         * 1. 最终 count 应该是多少？
         * 2. increment 为什么要加 synchronized？
         * 3. count++ 是不是天然线程安全？
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：2000。
         *
         * 问题 1：两个线程各加 1000 次，所以应该是 2000。
         *
         * 问题 2：保证同一时刻只有一个线程执行 increment，避免共享变量被同时修改。
         *
         * 问题 3：不是。count++ 包含读取、加一、写回多个步骤，
         *     多线程交叉执行时可能丢失更新。
         */
    }

    static void add(QuizCounter counter) {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

class QuizCounter {
    private int count;

    synchronized void increment() {
        count++;
    }

    int getCount() {
        return count;
    }
}
