package com.code.leet.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ValidPalindromeLeetCodeTest {

    // 13ms beats 41.08% | 44.82mb memory beats 27.81%
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0;
        int right = lower.length() - 1;
        while (left <= right) {
            if (lower.charAt(left++) != lower.charAt(right--)) return false;
        }
        return true;
    }

    // 3ms beats 73.75% | 42.68mb memory beats 86.03%
    public boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < s.length() && !Character.isAlphabetic(s.charAt(left)) && !Character.isDigit(s.charAt(left)))
            left++;
        while (right >= 0 && !Character.isAlphabetic(s.charAt(right)) && !Character.isDigit(s.charAt(right))) right--;
        while (left <= right) {
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            do {
                left++;
            } while (left < s.length() && !Character.isAlphabetic(s.charAt(left)) && !Character.isDigit(s.charAt(left)));
            do {
                right--;
            } while (right >= 0 && !Character.isAlphabetic(s.charAt(right)) && !Character.isDigit(s.charAt(right)));
        }
        return true;
    }

    @ParameterizedTest(name = "solution1: word={0}, isPalindrome={1}")
    @MethodSource("testInput")
    void test(String word, boolean answer) {
        boolean isPalindrome = isPalindrome(word);
        Assertions.assertEquals(answer, isPalindrome);
    }

    @ParameterizedTest(name = "solution2: word={0}, isPalindrome={1}")
    @MethodSource("testInput")
    void test2(String word, boolean answer) {
        boolean isPalindrome = isPalindrome2(word);
        Assertions.assertEquals(answer, isPalindrome);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("race a car", false),
                Arguments.of(" ", true),
                Arguments.of("0P", false),
                Arguments.of("a.", true)
        );
    }

}
