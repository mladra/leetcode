package com.code.leet.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LengthOfLastWordLeetCodeTest {

    public int lengthOfLastWord(String s) {
        String trimmed = s.trim();
        int idx = trimmed.lastIndexOf(' ');
        return trimmed.length() - idx - 1;
    }

    @ParameterizedTest(name = "words={0}, size={1}")
    @MethodSource("testInput")
    void test(String words, int expectedSize) {
        int size = lengthOfLastWord(words);
        Assertions.assertEquals(expectedSize, size);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6)
        );
    }
}
