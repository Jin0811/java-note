package thread;

/*
  ===== Runnable：把任务和线程分开 =====

  Runnable 表示一段"可运行的任务"，Thread 表示真正执行任务的线程。
  实际开发更推荐写 Runnable / Callable，再交给 Thread 或线程池执行。

  类比前端：
    Runnable 更像一个回调函数，描述"要做什么"；
    Thread 更像执行器，负责"什么时候、在哪条执行路线里做"。
*/

public class RunnableDemo {
    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
            }
        };

        Thread t1 = new Thread(task, "worker-1");
        Thread t2 = new Thread(task, "worker-2");

        t1.start();
        t2.start();
    }
}
