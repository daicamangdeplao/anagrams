package org.example.algorithm;

import org.example.Main;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.text.MessageFormat;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickCheckerTest {
    private static final String FILE_NAME = "testcases.csv";

    QuickChecker quickChecker = new QuickChecker();

    @Test
    void isAnagrams_should_return_true_for_all_cases_in_testcases() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(Main.class.getClassLoader().getResource(FILE_NAME).getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                System.out.println(MessageFormat.format("Test case: {0}, {1}", words[0], words[1]));
                assertTrue(quickChecker.isAnagrams(words[0], words[1]));
            }
        }
    }
}