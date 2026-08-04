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
         * 返回List<String>类型
         *
         * 2. 为什么要指定 StandardCharsets.UTF_8？
         * 因为java默认使用对应平台上的编码，不指定的话可能会出现乱码
         *
         * 3. 如果文件不存在，会发生什么？
         * 会出现运行时报错
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：readAllLines 返回什么类型？
         * 答：List<String>。
         *     每个元素是一整行（行尾换行符已去掉）。
         *     因为"一次读回多行"天然是个集合，所以用 List 装。
         *
         * 问题 2：为什么要指定 StandardCharsets.UTF_8？
         * 答：Java 不写字符集时会用【平台默认编码】，而它不一定是 UTF-8
         *     （比如中文 Windows 常是 GBK）。用 GBK 去解 UTF-8 的文件就会乱码。
         *     显式写 UTF_8 才能保证跨平台、中文不乱码。
         *     对比 JS：fs 默认按 utf8、字符串天生 Unicode，所以你几乎没这个烦恼。
         *
         * 问题 3：如果文件不存在，会发生什么？
         * 答：抛出 NoSuchFileException（IOException 的子类）。
         *     更关键的两点：
         *     1. 它是【受检异常】——编译器强制你处理。这正是本文件 main
         *        要写 throws IOException 的原因；不写，代码根本编译不过。
         *     2. 因为 main 把异常抛出去了，运行时才会真的崩溃并打印堆栈；
         *        如果 main 里 try/catch 了，程序就能优雅降级而不崩。
         *     对比 JS：fs 读不存在的文件也是运行时抛错，但 JS 不强制你处理，
         *     是"出了事再说"；Java 则是"编译期就逼你想清楚文件可能不存在"。
         */
    }
}
