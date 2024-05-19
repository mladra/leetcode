package com.code.leet.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class RansomNoteLeetCodeTest {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> countByLetters = new HashMap<>();
        int length = magazine.length();
        char character;
        for (int i = 0; i < length; i++) {
            character = magazine.charAt(i);
            countByLetters.put(character, countByLetters.getOrDefault(character, 0) + 1);
        }

        length = ransomNote.length();
        for (int i = 0; i < length; i++) {
            character = ransomNote.charAt(i);
            if (!countByLetters.containsKey(character)) return false;
            if (countByLetters.get(character) <= 0) return false;
            countByLetters.put(character, countByLetters.get(character) - 1);
        }
        return true;
    }

    @ParameterizedTest
    @MethodSource("testInput")
    void test(String ransomNote, String magazine, boolean result) {
        boolean value = canConstruct(ransomNote, magazine);
        Assertions.assertEquals(result, value);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of("a", "b", false),
                Arguments.of("aa", "ab", false),
                Arguments.of("aa", "aab", true)
        );
    }
}
