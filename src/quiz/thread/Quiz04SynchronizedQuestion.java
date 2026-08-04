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
