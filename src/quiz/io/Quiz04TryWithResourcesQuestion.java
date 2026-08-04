package quiz.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Quiz04TryWithResourcesQuestion {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src", "io", "TryWithResourcesDemo.java");

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            System.out.println(reader.readLine());
        }

        /*
         * 问题：
         * 1. try 小括号里的 reader 会在什么时候关闭？
         * 读取结束就会关闭
         *
         * 2. try-with-resources 解决了什么问题？
         * 之前的 Files.readAllLines 会一次性读取文件放在内存当中，如果文件很大，就会使用大量内存
         * try-with-resources 是逐行读取，性能比较好
         *
         * 3. 哪些对象能放进 try 小括号？
         * Reader类型，或者继承了Reader类型的子类
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：try 小括号里的 reader 会在什么时候关闭？
         * 答：try 代码块【结束的那一刻】自动调用 reader.close()。
         *     两个关键修饰：
         *     1. 自动：不用你手写 close()，语言帮你调；
         *     2. 一定：无论正常读完，还是中途抛异常，都会关闭。
         *     第 2 点才是它的核心价值——手写 close 时，异常路径上的 close
         *     很容易被跳过，导致资源泄漏。
         *
         * 问题 2：try-with-resources 解决了什么问题？
         * 答：解决的是【资源关闭的可靠性】问题，不是内存/性能问题。
         *     文件句柄、连接这类资源用完必须关闭，否则泄漏。
         *     传统写法要在 finally 里手动 close，容易忘、异常时易漏；
         *     try-with-resources 保证块一结束（含异常）必然关闭。
         *     【注意和"逐行读省内存"区分】那是 BufferedReader 流式读的特点，
         *     和怎么关无关：就算用老式 try/finally 手动关同一个 BufferedReader，
         *     一样是逐行、一样省内存。"怎么读"和"怎么关"是两件独立的事。
         *
         * 问题 3：哪些对象能放进 try 小括号？
         * 答：任何实现了【AutoCloseable 接口】的对象，不限于 Reader。
         *     BufferedReader 只是其中一个例子（它实现了 Closeable，
         *     Closeable 继承自 AutoCloseable）。
         *     其他常见例子：InputStream、OutputStream、Scanner、
         *     数据库 Connection、nio 的 Channel……
         *     判断标准只有一个：类有没有实现 close() 所要求的接口。
         *     类比 TS：≈ using 声明要求对象实现 Disposable 接口，
         *     AutoCloseable 就是 Java 版的 Disposable。
         */
    }
}
