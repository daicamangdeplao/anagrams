package org.example;

import org.example.algorithm.AnagramChecker;
import org.example.algorithm.PermutationChecker;
import org.example.algorithm.ProgramException;
import org.example.algorithm.QuickChecker;

import java.io.*;

// README with algorithm analysis
// Add tests

public class Main {

    public static void main(String[] args) throws ProgramException {
        if (args.length != 3) {
            throw new ProgramException("Number of arguments is not sufficient");
        }

        if (!args[0].equals("1") && !args[0].equals("2")) {
            throw new ProgramException("First argument must be either 1 or 2");
        }

        var algorithmType = args[0].equals("1") ? Type.PERMUTATION : Type.QUICK;
        var source = args[1];
        var target = args[2];

        boolean ret = switch (algorithmType) {
            case PERMUTATION -> {
                AnagramChecker checker1 = new PermutationChecker();
                yield checker1.isAnagrams(source, target);
            }
            case QUICK -> {
                AnagramChecker checker2 = new QuickChecker();
                yield checker2.isAnagrams(source, target);
            }
        };

        System.out.println(ret);
    }

    enum Type {
        PERMUTATION(1), QUICK(2);

        final int number;

        Type(int number) {
            this.number = number;
        }

        int getNumber() {
            return number;
        }
    }
}