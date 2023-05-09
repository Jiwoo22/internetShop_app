package com.solvd.internetShop;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FileReaderSample {
    public static void main(String[] args) throws IOException {
        String fileContents = FileUtils.readFileToString(new File("src/main/resources/sample.txt"), Charset.forName("UTF-8"));

        Set<String> uniqueWords = countUniqueWords(fileContents);

        FileUtils.writeStringToFile(new File("src/main/resources/output.txt"), "Unique word count: " + uniqueWords.size());
    }

    private static Set<String> countUniqueWords(String inputText) {
        String[] words = StringUtils.split(inputText, ", . - : ( )\n\t\"");
        System.out.println(Arrays.asList(words));
        return new HashSet<>(Arrays.asList(words));
    }
}


