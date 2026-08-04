package thread;

/*
  ===== 线程基础：Thread =====

  进程可以理解成一个正在运行的程序，线程是进程里的执行路线。
  Java 程序启动后，main 方法本身就运行在一个叫 main 的线程里。

  创建线程最直接的方式是 new Thread(...)，再调用 start()。
  注意：start() 才是启动新线程；如果直接调用 run()，只是普通方法调用，
  代码仍然在当前线程里执行。

  类比 JS/TS：
    JS 常见异步是事件循环 + Promise；
    Java 后端经常直接接触真正的多线程，例如 Web 容器用线程池处理请求。
*/

public class ThreadBasicDemo {
    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            System.out.println("worker thread = " + Thread.currentThread().getName());
        });

        worker.start();

        System.out.println("main thread = " + Thread.currentThread().getName());
    }
}
