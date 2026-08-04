package io;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
  ===== Path / Paths：只操作"路径字符串"，不碰磁盘 =====

  Path 是一个"路径对象"，Paths.get(...) 是它的工厂方法。
  注意：这里从头到尾【没有读写任何文件】，纯字符串层面的拼接/查询。

  类比 Node 的 path 模块（对前端最直观）：
    Paths.get("src", "io", "x.java")   ≈  path.join("src", "io", "x.java")
    path.getFileName()                 ≈  path.basename(p)
    path.getParent()                   ≈  path.dirname(p)
    path.toAbsolutePath()              ≈  path.resolve(p)  // 基于当前工作目录补全

  关键反直觉点：
    Paths.get 不在乎文件是否真实存在。你传个不存在的路径也能构造出 Path 对象，
    因为 Path 只是"路径的描述"，不是"文件本身"。要真正读/写文件才轮到 Files。
    —— 跟 Node 里 path.join 不会校验文件存在、fs 才会去读盘，是一个道理。

  为什么用 Paths.get("src","io","x") 这种"多段传参"而不是手写 "src/io/x"？
    因为分隔符是"平台相关"的：Windows 是 \，Linux/Mac 是 /。
    多段传参让 Paths.get 自动用当前系统的分隔符拼，跨平台不用自己操心。
    （跟 path.join 帮你处理分隔符一个动机。）
*/

public class FilePathDemo {
    public static void main(String[] args) {
        // 多段传参，由 Paths.get 按平台分隔符拼出路径（这里文件真实存在）。
        Path path = Paths.get("src", "io", "FilePathDemo.java");

        System.out.println("path = " + path);                          // 拼好的相对路径
        System.out.println("fileName = " + path.getFileName());        // ≈ basename → FilePathDemo.java
        System.out.println("parent = " + path.getParent());            // ≈ dirname  → src/io
        System.out.println("absolutePath = " + path.toAbsolutePath()); // ≈ resolve  → 基于工作目录补全
    }
}
