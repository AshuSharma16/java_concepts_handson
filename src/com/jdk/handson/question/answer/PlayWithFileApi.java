package com.jdk.handson.question.answer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PlayWithFileApi {

    public static void main (String[] args) throws IOException {

        System.out.println("----------read data from file");
        final List<String> filesData = Files.readAllLines(Paths.get("data.txt"));
        //  filesData.stream().forEach(System.out::println);
        System.out.println(filesData.size());
        filesData.stream().skip(1)
                .limit(filesData.size()-2)
                .forEach(System.out::println);
    }
}
