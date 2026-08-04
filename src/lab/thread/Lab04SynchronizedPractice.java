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
    }

    static void add1000(SafeCounter counter) {
        // TODO: 循环调用 counter.increment()。
    }
}

class SafeCounter {
    private int count;

    synchronized void increment() {
        // TODO: 累加 count。
    }

    int getCount() {
        return count;
    }
}
