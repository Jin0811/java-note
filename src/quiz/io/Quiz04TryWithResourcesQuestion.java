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
         * 2. try-with-resources 解决了什么问题？
         * 3. 哪些对象能放进 try 小括号？
         */
    }
}
