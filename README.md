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

* two possible solutions
  * recursive solution: Adopt permutation approach by listing all possible permutation of a string (including the space character).
  * stream solution: Two anagrams must have the same characters.

## Algorithm Analysis

n/a

## References

1. https://stackoverflow.com/a/4240323/5657159
2. https://introcs.cs.princeton.edu/java/23recursion/
3. https://stackoverflow.com/a/9689877/5657159