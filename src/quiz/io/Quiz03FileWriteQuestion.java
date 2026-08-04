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
    }
}
