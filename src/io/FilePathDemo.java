package io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePathDemo {
    public static void main(String[] args) {
        Path path = Paths.get("src", "io", "FilePathDemo.java");

        System.out.println("path = " + path);
        System.out.println("fileName = " + path.getFileName());
        System.out.println("parent = " + path.getParent());
        System.out.println("absolutePath = " + path.toAbsolutePath());
    }
}

