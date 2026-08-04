package thread;

/*
  ===== synchronized：保护共享数据 =====

  多个线程同时修改同一个变量时，可能出现竞态条件。
  synchronized 可以给关键代码加锁，保证同一时刻只有一个线程进入。

  实际开发中不会只靠 synchronized 打天下，但它是理解线程安全、
  锁、事务、缓存一致性等后端概念的入口。
*/

public class SynchronizedDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> addMany(counter), "counter-1");
        Thread t2 = new Thread(() -> addMany(counter), "counter-2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("count = " + counter.getCount());
    }

    static void addMany(Counter counter) {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

class Counter {
    private int count;

    synchronized void increment() {
        count++;
    }

    int getCount() {
        return count;
    }
}
