package com.code.leet.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

// 169. Majority Element
public class MajorityElementLeetCodeTest {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int biggestNum = nums[0];
        int biggestNumCount = 1;
        int currentNum = nums[1];
        int currentNumCount = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == currentNum) {
                currentNumCount++;
                if (currentNumCount > biggestNumCount) {
                    biggestNum = currentNum;
                    biggestNumCount = currentNumCount;
                }
            } else {
                currentNumCount = 1;
                currentNum = nums[i];
            }
        }
        return biggestNum;
    }

    @ParameterizedTest(name = "nums={0}, expectedMajorityNumber={1}")
    @MethodSource("testInput")
    void test(int[] nums, int expectedNumber) {
        int element = majorityElement(nums);
        Assertions.assertEquals(expectedNumber, element);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 3}, 3),
                Arguments.of(new int[]{2, 2, 1, 1, 1, 2, 2}, 2),
                Arguments.of(new int[]{1}, 1)
        );
    }

}
