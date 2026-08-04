package quiz.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Quiz02FileReadQuestion {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src", "io", "FileReadDemo.java");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        System.out.println(lines.size() > 0);
        System.out.println(lines.get(0));

        /*
         * 问题：
         * 1. readAllLines 返回什么类型？
         * 2. 为什么要指定 StandardCharsets.UTF_8？
         * 3. 如果文件不存在，会发生什么？
         */
    }
}
