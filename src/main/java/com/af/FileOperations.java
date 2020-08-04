package com.af;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileOperations {
    public static void main(String[] args) throws IOException {

        CollectorExamples.printDash();
        Files.lines(Paths.get("sample.txt"))
                .filter(line -> line.contains("Hello"))
                .forEach(System.out::println);

        CollectorExamples.printDash();
        Files.lines(Paths.get("sample.txt"))
                .map(line -> line.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        CollectorExamples.printDash();
        Files.list(Paths.get("."))
                .forEach(System.out::println);

        CollectorExamples.printDash();
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);
    }
}
