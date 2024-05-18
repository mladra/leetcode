package com.code.leet.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LongestCommonPrefixLeetCodeTest {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int colLength = strs[0].length();
        StringBuilder prefix = new StringBuilder(200);
        for (int i = 0; i < colLength; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    return prefix.toString();
                }
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    return prefix.toString();
                }
            }
            prefix.append(strs[0].charAt(i));
        }
        return prefix.toString();
    }

    @ParameterizedTest(name = "words={0}, expectedPrefix={1}")
    @MethodSource("testInput")
    void test(String[] words, String expectedPrefix) {
        String prefix = longestCommonPrefix(words);
        Assertions.assertEquals(expectedPrefix, prefix);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"dog", "racecar", "car"}, ""),
                Arguments.of(new String[]{"ab", "a"}, "a")
        );
    }

}
