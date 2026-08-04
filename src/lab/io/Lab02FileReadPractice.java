package lab.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Lab02FileReadPractice {
    public static void main(String[] args) throws IOException {
        /*
         * 练习目标：读取文本文件。
         *
         * TODO:
         * 1. 读取 src/io/FileReadDemo.java。
         * 2. 输出总行数。
         * 3. 输出第一行。
         * 4. 判断文件内容中是否包含 "readAllLines"。
         */

        Path path = Paths.get("src", "io", "FileReadDemo.java");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        System.out.println("line count = " + lines.size());
        System.out.println("first line = " + lines.get(0));
        System.out.println("contains readAllLines = " + lines.toString().contains("readAllLines"));
    }
}
