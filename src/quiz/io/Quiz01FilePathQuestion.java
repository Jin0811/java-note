package quiz.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Quiz01FilePathQuestion {
    public static void main(String[] args) {
        Path path = Paths.get("src", "io", "FilePathDemo.java");

        System.out.println(path.getFileName());
        System.out.println(path.getParent());

        /*
         * 问题：
         * 1. getFileName() 输出什么？
         * 2. getParent() 输出什么？
         * 3. Path 和 String 路径相比有什么好处？
         */
    }
}
