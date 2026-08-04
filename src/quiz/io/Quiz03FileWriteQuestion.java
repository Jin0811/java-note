package quiz.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class Quiz03FileWriteQuestion {
    public static void main(String[] args) throws IOException {
        Path outputDir = Paths.get("tmp");
        Files.createDirectories(outputDir);

        Path outputFile = outputDir.resolve("quiz-io-output.txt");
        Files.writeString(outputFile, "Java IO", StandardCharsets.UTF_8);

        System.out.println(Files.exists(outputFile));
        System.out.println(Files.readString(outputFile, StandardCharsets.UTF_8));

        /*
         * 问题：
         * 1. createDirectories 的作用是什么？
         * 创建目录
         *
         * 2. resolve("quiz-io-output.txt") 做了什么？
         * 进行路径拼接
         *
         * 3. writeString 默认会覆盖还是追加？
         * 默认是覆盖，可以传递 StandardOpenOption.APPEND 来追加
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：createDirectories 的作用是什么？
         * 答：创建目录，关键特性有两个：
         *     1. 【递归创建】：父目录不存在会一起建出来，
         *        Paths.get("a/b/c") 一次建三级。
         *     2. 【已存在不报错】：重复调用安全，适合写文件前"确保目录在"。
         *     对比 Files.createDirectory（单数版）：只能建一级、父目录缺失
         *     或目录已存在都会抛异常。
         *     类比 Node：≈ fs.mkdirSync(dir, { recursive: true })。
         *
         * 问题 2：resolve("quiz-io-output.txt") 做了什么？
         * 答：路径拼接：把子路径接到父路径后面，
         *     tmp + quiz-io-output.txt → tmp/quiz-io-output.txt。
         *     两个补充：
         *     1. 纯字符串层面的操作，不碰磁盘、不检查文件是否存在；
         *     2. ≈ Node 的 path.join(dir, name)。
         *
         * 问题 3：writeString 默认会覆盖还是追加？
         * 答：默认【覆盖】（文件已有内容整个被替换）。
         *     要追加需显式传：
         *       Files.writeString(path, s, StandardCharsets.UTF_8,
         *                         StandardOpenOption.APPEND);
         *     类比 Node：默认覆盖 ≈ fs.writeFileSync，追加 ≈ fs.appendFileSync。
         */
    }
}
