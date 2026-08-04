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
         * 文件名称，即FilePathDemo.java
         *
         * 2. getParent() 输出什么？
         * 输出的是上级目录名称，即io
         *
         * 3. Path 和 String 路径相比有什么好处？
         * - Path当中可以根据平台判断使用分隔符，String需要自己判断
         * - Path当中提供了多种方法，如getFileName，而String上没有
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：getFileName() 输出什么？
         * 答：FilePathDemo.java
         *     getFileName() 取的是路径的【最后一个名称元素】。
         *     类比 Node：path.basename("src/io/FilePathDemo.java") === "FilePathDemo.java"。
         *
         * 问题 2：getParent() 输出什么？
         * 答：Windows 上是 src\io（Linux/Mac 是 src/io）——不是单个 "io"！
         *     getParent() 返回"去掉最后一个元素后"的【整段父路径】：
         *     src/io/FilePathDemo.java 去掉文件名，剩 src/io。
         *     "io" 只是父路径里离文件最近的那一层，不是 getParent() 的返回值。
         *     类比 Node：path.dirname()，结果同样是 "src/io"。
         *
         * 问题 3：Path 和 String 路径相比有什么好处？
         * 答：主要有三点：
         *     1. 跨平台分隔符：Paths.get("src","io","x") 自动按当前系统选分隔符，
         *        String 手写要自己操心 \ 和 /，跨平台容易错。
         *     2. 结构化路径操作：getFileName/getParent/resolve/relativize/normalize
         *        等现成方法；String 只能 indexOf/split 手工拆，繁琐且易错。
         *     3. 类型语义 + 与 Files 配套：文件读写 API（Files.readAllLines 等）
         *        参数都是 Path；方法签名用 Path 比 String 更明确表达"这是个路径"。
         */
    }
}
