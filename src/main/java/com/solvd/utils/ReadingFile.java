package com.solvd.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReadingFile {
    public static int getUniqueWordCountInFile (String file) throws IOException {
        String fileContents = FileUtils.readFileToString(new File(file),
                Charset.forName("UTF-8"));

        Set<String> uniqueWords = countUniqueWords(fileContents);

        return uniqueWords.size();
    }

    private static Set<String> countUniqueWords (String inputText) {
        String[] words = StringUtils.split(inputText, ", . - : ( )\n\t\"");
        return new HashSet<>(Arrays.asList(words));
    }
}


