# Anagrams

## Introduction

A fun program serves for the purpose of playing around with texts.

## How to build

To make jar file be executable, we need to jar a file called ``META-INF/MANIFEST.MF`` by supplementing

````groovy
jar {
    manifest {
        attributes(
                'Main-Class': 'com.mypackage.MyClass'
        )
    }
}
````

Then, do the build with the command

````groovy
gradle jar
````

## How to run

The program takes three arguments:

* ``algorithm_type``, either 1 or 2
* ``source_text``
* ``target_text``

The command line will look like as following

````shell
java -jar anagrams-1.0-SNAPSHOT.jar 2 "New York Times" "monkeys write"
````

## Solution

* Two possible solutions:
  * Recursive solution
    * Adopt permutation approach by listing all possible permutation of a string (including the space character).
    * Try to list all of possible permutations of the text.
    * If the list contains the anagram then they are anagrams.
  * Stream solution
    * Based on the facts:
      * Two anagrams must have the same number of words.
      * Two anagrams must have the same characters, just maybe in different orders.
    * Standardise the text by:
      * Get rid of space characters.
      * All characters must be lowered case.
      * Characters must be sorted in a consistent order.
    * Two words are anagrams, if two standardised texts are equal.

## Algorithm Analysis

The interesting time complexity happens when we adopt the recursive solution by listing all of possible permutation of the text.

````
    private void check(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);
        }

        for (int i = 0; i < n; i++) {
            check(
                    prefix + str.charAt(i),
                    str.substring(0, i) + str.substring(i + 1, n)
            );
        }
    }

````

* At the first look, the loop takes ``n`` times to finish.
* Inside the loop, the recursive takes place with a string size is decreased by ``1``, i.e. ``n - 1``.
* The recursive get deeper until the size of the text is ``0``.

By using these three observations, the recursive algorithm takes ``n!`` steps to finish the run. Therefore, the worst case of time complexity is ``O(n!)``, or ``O(n^n)``. 

## References

1. https://stackoverflow.com/a/4240323/5657159
2. https://introcs.cs.princeton.edu/java/23recursion/
3. https://stackoverflow.com/a/9689877/5657159