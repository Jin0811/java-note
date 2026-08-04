package quiz.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
         * 2. resolve("quiz-io-output.txt") 做了什么？
         * 3. writeString 默认会覆盖还是追加？
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * true
         * Java IO
         *
         * 问题 1：创建目录。如果目录已存在，不会报错。
         *
         * 问题 2：在 outputDir 后面拼接一个子路径，得到 tmp/quiz-io-output.txt。
         *
         * 问题 3：这里的 writeString 会覆盖原文件内容。
         *     如果想追加，需要使用 StandardOpenOption.APPEND。
         */
    }
}
