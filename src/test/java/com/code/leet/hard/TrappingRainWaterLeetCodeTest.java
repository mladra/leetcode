package com.code.leet.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Disabled
public class TrappingRainWaterLeetCodeTest {

    public int trap(int[] height) {
        throw new RuntimeException("To be implemented");
    }

    @ParameterizedTest(name = "array={0}, expectedSum={1}")
    @MethodSource("testInput")
    void test(int[] array, int expectedSum) {
        int sum = trap(array);
        Assertions.assertEquals(expectedSum, sum);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
                Arguments.of(new int[]{4, 2, 0, 3, 2, 5}, 9)
        );
    }
}
