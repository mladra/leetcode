package com.code.leet.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RomanToIntegerLeetCodeTest {

    public int romanToInt(String text) {
        int i, sum = 0;
        for (i = 0; i < text.length() - 1; i++) {
            switch (text.charAt(i)) {
                case 'I':
                    if (text.charAt(i + 1) == 'V') {
                        sum += 4;
                        i++;
                    } else if (text.charAt(i + 1) == 'X') {
                        sum += 9;
                        i++;
                    } else {
                        sum += 1;
                    }
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if (text.charAt(i + 1) == 'L') {
                        sum += 40;
                        i++;
                    } else if (text.charAt(i + 1) == 'C') {
                        sum += 90;
                        i++;
                    } else {
                        sum += 10;
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    if (text.charAt(i + 1) == 'D') {
                        sum += 400;
                        i++;
                    } else if (text.charAt(i + 1) == 'M') {
                        sum += 900;
                        i++;
                    } else {
                        sum += 100;
                    }
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }
        }
        if (i == text.length() - 1) {
            sum += switch (text.charAt(text.length() - 1)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default ->
                        throw new IllegalArgumentException("Unknown roman symbol: " + text.charAt(text.length() - 1));
            };
        }
        return sum;
    }

    @ParameterizedTest(name = "roman={0}, int={1}")
    @MethodSource("testInput")
    void test(String roman, int expectedNum) {
        int num = romanToInt(roman);
        Assertions.assertEquals(expectedNum, num);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of("III", 3),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994)
        );
    }
}
