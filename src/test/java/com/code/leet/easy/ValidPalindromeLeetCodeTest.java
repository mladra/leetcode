package com.code.leet.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ValidPalindromeLeetCodeTest {

    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0;
        int right = lower.length() - 1;
        while (left <= right) {
            if (lower.charAt(left++) != lower.charAt(right--)) return false;
        }
        return true;
    }

    @ParameterizedTest(name = "word={0}, isPalindrome={1}")
    @MethodSource("testInput")
    void test(String word, boolean answer) {
        boolean isPalindrome = isPalindrome(word);
        Assertions.assertEquals(answer, isPalindrome);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("race a car", false),
                Arguments.of(" ", true),
                Arguments.of("0P", false)
        );
    }

}
