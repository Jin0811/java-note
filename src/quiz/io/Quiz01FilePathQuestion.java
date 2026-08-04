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

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * FilePathDemo.java
         * src\io
         *
         * 问题 1：输出最后一级路径，也就是 FilePathDemo.java。
         *
         * 问题 2：输出父路径 src\io。不同系统分隔符可能显示为 / 或 \。
         *
         * 问题 3：Path 是专门表示路径的对象，能方便地取文件名、父目录、
         *     拼接子路径、转绝对路径，比手写字符串更不容易出错。
         */
    }
}
