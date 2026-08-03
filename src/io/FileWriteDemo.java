package io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriteDemo {
    public static void main(String[] args) throws IOException {
        Path outputDir = Paths.get("tmp");
        Files.createDirectories(outputDir);

        Path outputFile = outputDir.resolve("java-io-demo.txt");
        String content = "Hello Java IO\n这是 Java 写入的文件内容";

        Files.writeString(outputFile, content, StandardCharsets.UTF_8);
        System.out.println("wrote file = " + outputFile.toAbsolutePath());
    }
}

