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
         * 3. 逐行输出文件内容
         */
        Path filePath = Paths.get("tmp", "lab-io-output.txt");
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

//            String line = reader.readLine();
//            while (line != null) {
//                System.out.println(line);
//                line = reader.readLine();
//            }
        }
    }
}
