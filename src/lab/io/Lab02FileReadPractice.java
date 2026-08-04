package lab.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Lab02FileReadPractice {
    /*
     * 练习目标：读取文本文件。
     *
     * 要点：
     * 1. readAllLines 把文件读成 List<String>，每个元素是一整行。
     * 2. lines.contains(x) 判断的是"有没有某一行整行等于 x"，
     *    而不是"内容里包含子串 x"。要找子串得逐行用 contains。
     */

    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("src/io/FileReadDemo.java");
        List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);

        // 总行数
        System.out.println(lines.size());
        // 第一行
        System.out.println(lines.get(0));

        // 判断文件内容中是否包含子串 "readAllLines"，逐行做子串匹配
        boolean has = false;
        for (String line : lines) {
            if (line.contains("readAllLines")) {
                has = true;
                break;
            }
        }
        System.out.println(has);
    }
}
