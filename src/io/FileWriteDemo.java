package io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
  ===== Files.writeString：一行写出整个文件 =====

  类比 Node：
    fs.mkdirSync(dir, { recursive: true })   ≈  Files.createDirectories(dir)
    path.join(dir, "x.txt")                  ≈  dir.resolve("x.txt")
    fs.writeFileSync(p, content, "utf8")     ≈  Files.writeString(p, content, UTF_8)

  关键行为（和 Node 一致，但值得记）：
    - Files.createDirectories：目录已存在【不报错】（等价 recursive:true），
      一次可建多级（如 tmp/a/b）。
    - Files.writeString：默认"覆盖写"。想追加要用
      Files.writeString(p, s, StandardOpenOption.APPEND)。
      —— 对应 fs.appendFileSync。
    - 目标目录不存在时直接 writeString 会抛 NoSuchFileException，
      所以这里先 createDirectories(outputDir) 再写，顺序不能反。

  resolve 的语义：把子路径接到父路径后面，等价 path.join，
  同样不碰磁盘，纯字符串层面拼路径。
*/

public class FileWriteDemo {
    public static void main(String[] args) throws IOException {
        Path outputDir = Paths.get("tmp");
        // 先确保目录存在（已存在也不报错），否则下一步写文件会抛 NoSuchFileException。
        Files.createDirectories(outputDir);

        // resolve ≈ path.join：把文件名拼到目录后面，不检查磁盘。
        Path outputFile = outputDir.resolve("java-io-demo.txt");
        String content = "Hello Java IO\n这是 Java 写入的文件内容";

        // 覆盖写；显式 UTF_8，保证中文不乱码。
        Files.writeString(outputFile, content, StandardCharsets.UTF_8);
        // 打印写出的绝对路径，方便去 tmp/ 下查看结果。
        System.out.println("wrote file = " + outputFile.toAbsolutePath());
    }
}
