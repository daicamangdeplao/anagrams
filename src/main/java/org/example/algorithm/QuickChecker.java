package org.example.algorithm;

import java.util.List;

import static org.example.Utils.removeSpaceCharacters;

public class QuickChecker implements AnagramChecker {
    @Override
    public boolean isAnagrams(String text1, String text2) {
        List<String> s1 = standardizeText(text1);
        List<String> s2 = standardizeText(text2);
        return String.join("", s1).equalsIgnoreCase(String.join("", s2));
    }

    private List<String> standardizeText(String text) {
        return removeSpaceCharacters(text).chars()
                .mapToObj(c -> String.valueOf((char) c))
                .map(String::toLowerCase)
                .sorted(String::compareTo)
                .toList();
    }
}
