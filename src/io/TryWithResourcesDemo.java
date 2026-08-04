package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
  ===== try-with-resources：资源自动关闭（Java 7+）=====

  先理解"资源"：文件句柄、数据库连接、网络 Socket 这类东西
  用完必须手动 close()，否则就是资源泄漏。对应到前端：
  Node 里 fs.promises.open() 得到的 FileHandle 也要 handle.close()，
  忘了就是句柄泄漏——同一个道理。

  Java 的传统写法是 try/finally 里手动 close（又啰嗦又容易漏）：
      BufferedReader reader = Files.newBufferedReader(path);
      try {
          // 用 reader...
      } finally {
          reader.close();   // 忘了这行 = 泄漏
      }

  try-with-resources 把这一步自动化：
      try (BufferedReader reader = ...) { 用 reader... }
      // 代码块结束（无论正常结束还是抛异常），自动调 reader.close()

  【TS 完美对照物】就是 "显式资源管理"（using 声明，TC39 提案）：
      using reader = await openReader(path);   // ≈ try (BufferedReader reader = ...)
      // 作用域结束自动触发 reader[Symbol.dispose]()
  Java 的 AutoCloseable 接口 ≈ TS 的 Disposable 接口（都只需实现一个"关闭方法"），
  try-with-resources ≈ using。思路完全同源：把"记得关"变成"语言替你关"。

  为什么用 BufferedReader 而不是 readAllLines：
    readAllLines 一次性把整个文件读进内存；
    BufferedReader.readLine() 是【流式】逐行读，内存里只留当前行。
    几行的小文件用哪个都行，但大文件（几百 MB 日志）必须流式。
*/

public class TryWithResourcesDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src", "io", "TryWithResourcesDemo.java");

        // try-with-resources 会在代码块结束后自动关闭 reader。
        // 条件：BufferedReader 实现了 AutoCloseable 接口（≈ TS 的 Disposable）。
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            // 流式读：readLine() 每次只读一行，文件不整块进内存。
            String firstLine = reader.readLine();
//            System.out.println("firstLine = " + firstLine);
        } // 出块即自动 reader.close()，即使中途抛异常也不例外
    }
}
