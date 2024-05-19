package com.code.leet.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IsSubsequenceLeetCodeTest {

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.isEmpty()) return true;
        if (t == null || t.isEmpty()) return false;

        int tL = t.length();
        int sL = s.length();
        if (sL > tL) return false;

        int idx = 0;
        for (int i = 0; i < tL; i++) {
            if (s.charAt(idx) == t.charAt(i)) idx++;
            if (idx >= sL) return true;
        }
        return false;
    }

    @ParameterizedTest(name = "subsequence={0}, sequence={1}, result={2}")
    @MethodSource("testInput")
    void test(String subsequence, String sequence, boolean result) {
        boolean value = isSubsequence(subsequence, sequence);
        Assertions.assertEquals(result, value);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of("abc", "ahbgdc", true),
                Arguments.of("axc", "ahbgdc", false),
                Arguments.of("", "ahbgdc", true),
                Arguments.of("b", "abc", true)
        );
    }

}
