package org.example.algorithm;

import org.example.Utils;

public class PermutationChecker implements AnagramChecker {
    private boolean found = false;

    @Override
    public boolean isAnagrams(String source, String target) {
        check(
                "",
                Utils.removeSpaceCharacters(source),
                Utils.removeSpaceCharacters(target)
        );
        return found;
    }

    private void check(String prefix, String str, String anagram) {
        int n = str.length();
        if (n == 0 && prefix.equalsIgnoreCase(anagram)) {
            found = true;
        }

        for (int i = 0; i < n; i++) {
            if (found) {
                return;
            }
            check(
                    prefix + str.charAt(i),
                    str.substring(0, i) + str.substring(i + 1, n),
                    anagram
            );
        }
    }
}
