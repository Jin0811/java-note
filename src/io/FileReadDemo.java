package io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReadDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src", "io", "FileReadDemo.java");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        System.out.println("line count = " + lines.size());
        System.out.println("first line = " + lines.get(0));
    }
}

