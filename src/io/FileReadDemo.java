package io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
  ===== Files.readAllLines：把小文件一次性读进内存 =====

  Files.readAllLines(path, charset) 返回 List<String>，每个元素是"一整行"
  （行尾的换行符已被去掉，跟 Node 里 text.split("\n") 的结果形态一致）。

  类比 Node：
    fs.readFileSync(path, "utf8").split("\n")   ≈   Files.readAllLines(path, UTF_8)

  两个 Java 特有的注意点：
    1. 必须显式指定字符集 StandardCharsets.UTF_8。
       JS/TS 字符串天生是 Unicode、fs 默认就按 utf8，你几乎没感知；
       而 Java 不写字符集可能用平台默认编码（中文 Windows 常是 GBK），
       中文就会乱码。所以 Java IO 里"显式写 UTF_8"是肌肉记忆。
    2. throws IOException：读文件必然可能失败（文件不存在、没权限……），
       Java 是"受检异常"，编译器强制你处理——要么 try/catch，要么像这里
       一路 throws 抛出去交给 main 交给 JVM。JS 里读写失败是运行时才抛的，
       不强制处理，这是两种语言在"异常哲学"上的差别。

  适用边界：
    readAllLines 会【把整个文件读进内存】，适合小文件/配置文件。
    读大文件（几百 MB 日志）会扛不住内存，要用 TryWithResourcesDemo 那种
    BufferedReader 流式逐行读。
*/

public class FileReadDemo {
    public static void main(String[] args) throws IOException {
        // Paths.get("src","io","FileReadDemo.java")：读自己这个源文件。多段传参自动处理分隔符。
        Path path = Paths.get("src", "io", "FileReadDemo.java");
        // 一次性读全部行；显式指定 UTF_8，避免平台默认编码导致中文乱码。
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        System.out.println("line count = " + lines.size());  // 总行数
        System.out.println("first line = " + lines.get(0));  // 第一行（list 越界会抛 IndexOutOfBounds）
    }
}
