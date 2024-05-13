package com.code.leet.medium;

import com.code.leet.utils.CollectionTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

// 80. Remove Duplicates from Sorted Array II
@Disabled(value = " Zadanie nie jest zrealizowane")
public class RemoveDuplicatesFromSortedArray2LeetCodeTest {

    public int removeDuplicates(int[] nums) {
        int idx = 0;
        int count = 0;
        int num = nums[0];
        while (idx < nums.length) {
            if (nums[idx] == num) {
                count++;
            }
            if (count > 2) nums[idx] = 0;
            if (nums[idx] != num) {
                num = nums[idx];
                count = 0;
            }
            idx++;
        }
        return -1;
    }

    @ParameterizedTest(name = "nums={0}, expectedNums={1}")
    @MethodSource("testInput")
    void test(int[] nums, int[] expectedNums) {
        int k = removeDuplicates(nums);
        Assertions.assertEquals(expectedNums.length, k);
        int[] uniqueNums = CollectionTestUtils.subArray(nums, k);
        CollectionTestUtils.assertArray(expectedNums, uniqueNums);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, new int[]{1, 1, 2, 2, 3}),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 3, 3})
        );
    }

}
