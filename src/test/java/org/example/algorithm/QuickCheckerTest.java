package org.example.algorithm;

import org.example.Main;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class QuickCheckerTest {
    private static final String FILE_NAME = "testcases.csv";

    QuickChecker quickChecker = new QuickChecker();

    @Test
    void isAnagrams_should_return_true_for_all_cases_in_testcases() throws IOException {
        URL resource = Main.class.getClassLoader().getResource(FILE_NAME);
        try (BufferedReader br = new BufferedReader(new FileReader(Objects.requireNonNull(resource).getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                System.out.println(MessageFormat.format("Test case: {0}, {1}", words[0], words[1]));
                assertTrue(quickChecker.isAnagrams(words[0], words[1]));
            }
        }
    }
}