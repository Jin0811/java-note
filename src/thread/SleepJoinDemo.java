package thread;

/*
  ===== sleep 和 join =====

  Thread.sleep(ms)：让当前线程暂停一段时间。
  thread.join()：让当前线程等待另一个线程执行完。

  注意：sleep 和 join 都可能抛 InterruptedException。
  这是 Java 让线程有机会被外部中断的一种机制，后续线程池会更常见。
*/

public class SleepJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("working " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("worker interrupted");
                    return;
                }
            }
        });

        worker.start();
        worker.join();

        System.out.println("main waits until worker done");
    }
}
