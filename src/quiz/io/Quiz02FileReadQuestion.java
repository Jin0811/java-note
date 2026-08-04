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

        /*
         * ========== 标准答案 ==========
         *
         * 第一行输出 true，第二行输出被读取文件的第一行：package io;
         *
         * 问题 1：返回 List<String>，文件每一行对应集合里的一个字符串。
         *
         * 问题 2：明确编码，避免中文在不同系统默认编码下读取乱码。
         *
         * 问题 3：会抛出 IOException 的子类 NoSuchFileException。
         *     本题 main 方法声明了 throws IOException，所以异常会继续向外抛。
         */
    }
}
