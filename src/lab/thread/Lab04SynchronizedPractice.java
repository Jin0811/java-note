package lab.thread;

public class Lab04SynchronizedPractice {
    public static void main(String[] args) throws InterruptedException {
        /*
         * 练习目标：synchronized 保护共享变量。
         *
         * TODO:
         * 1. 创建 SafeCounter。
         * 2. 创建两个线程，各自累加 1000 次。
         * 3. 使用 join 等待两个线程结束。
         * 4. 输出最终 count，应该是 2000。
         */

        SafeCounter counter = new SafeCounter();

        Thread t1 = new Thread(() -> add1000(counter));
        Thread t2 = new Thread(() -> add1000(counter));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter.getCount());
    }

    static void add1000(SafeCounter counter) {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

class SafeCounter {
    private int count;

    synchronized void increment() {
        count++;
    }

    int getCount() {
        return count;
    }
}
