package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TryWithResourcesDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src", "io", "TryWithResourcesDemo.java");

        // try-with-resources 会在代码块结束后自动关闭 reader。
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String firstLine = reader.readLine();
            System.out.println("firstLine = " + firstLine);
        }
    }
}

