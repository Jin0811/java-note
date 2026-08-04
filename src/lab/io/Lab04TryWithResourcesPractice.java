package lab.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lab04TryWithResourcesPractice {
    public static void main(String[] args) throws IOException {
        /*
         * 练习目标：try-with-resources 自动关闭资源。
         *
         * TODO:
         * 1. 使用 Files.newBufferedReader 创建 reader。
         * 2. 放在 try (...) 小括号中。
         * 3. 读取并输出第一行。
         */

        Path path = Paths.get("src", "io", "TryWithResourcesDemo.java");

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String firstLine = reader.readLine();
            System.out.println(firstLine);
        }
    }
}
