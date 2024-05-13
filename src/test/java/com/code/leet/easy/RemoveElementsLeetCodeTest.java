package com.code.leet.easy;

import com.code.leet.utils.CollectionTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

// 27. Remove Element
public class RemoveElementsLeetCodeTest {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1 && nums[0] != val) return 1;
        if (nums.length == 1 && nums[0] == val) return 0;

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                nums[right--] = val;
            } else {
                left++;
            }
        }

        int idx = 0;
        int count = 0;
        while (idx < nums.length) {
            if (nums[idx++] != val) count++;
        }
        return count;
    }

    @ParameterizedTest(name = "nums={0}, val={1}, expectedNums={2}")
    @MethodSource("testInput")
    void test(int[] nums, int val, int[] expectedNums) {
        int k = removeElement(nums, val);
        Assertions.assertEquals(expectedNums.length, k);
        int[] differentNums = CollectionTestUtils.subArray(nums, k);
        Arrays.sort(differentNums, 0, k);
        CollectionTestUtils.assertArray(expectedNums, differentNums);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 2, 3}, 3, new int[]{2, 2}),
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 0, 1, 3, 4}),
                Arguments.of(new int[]{1}, 1, new int[0]),
                Arguments.of(new int[]{3, 3}, 3, new int[0])
        );
    }

}
