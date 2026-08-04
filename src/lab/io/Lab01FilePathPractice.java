package lab.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lab01FilePathPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：Path / Paths 基础。
         *
         * TODO:
         * 1. 使用 Paths.get 创建 src/io/FilePathDemo.java 路径。
         * 2. 输出文件名。
         * 3. 输出父目录。
         * 4. 输出绝对路径。
         */

        Path filePath = Paths.get("src/io/FilePathDemo.java");
        System.out.println(filePath.getFileName());
        System.out.println(filePath.getParent());
        System.out.println(filePath.toAbsolutePath());
    }
}
