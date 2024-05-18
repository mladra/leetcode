package com.code.leet.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FindTheIndexOfTheFirstOccurrenceInAStringLeetCodeTest {

    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.isEmpty()) return -1;
        if (needle == null || needle.isEmpty()) return -1;

        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) return -1;
            String substring = haystack.substring(i, i + needle.length());
            if (substring.equals(needle)) return i;
        }

        return -1;
    }

    @ParameterizedTest
    @MethodSource("testInput")
    void test(String haystack, String needle, int expectedIndex) {
        int index = strStr(haystack, needle);
        Assertions.assertEquals(expectedIndex, index);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of("sadbutsad", "sad", 0),
                Arguments.of("leetcode", "leeto", -1)
        );
    }

}
