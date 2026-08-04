package lab.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Lab03FileWritePractice {
    public static void main(String[] args) throws IOException {
        /*
         * 练习目标：写入文本文件。
         *
         * TODO:
         * 1. 创建 tmp 目录。
         * 2. 写入 tmp/lab-io-output.txt。
         * 3. 再读回文件内容并输出。
         */
        Path outputDir = Paths.get("tmp");
        Files.createDirectories(outputDir);

        Path outputFile = outputDir.resolve("lab-io-output.txt");

        String content = "Hello Java IO\n这是 Java 写入的文件内容";
        Files.writeString(outputFile, content, StandardCharsets.UTF_8);

        List<String> lines = Files.readAllLines(outputFile, StandardCharsets.UTF_8);
        System.out.println(lines);
    }
}
