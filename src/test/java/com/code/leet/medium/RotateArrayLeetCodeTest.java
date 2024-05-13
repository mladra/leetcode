package com.code.leet.medium;

import com.code.leet.utils.CollectionTestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

// 189. Rotate Array
public class RotateArrayLeetCodeTest {

    // 6 ms (beats 5.51%) | 55,79 mb memory (beats 95.84%)
    public void rotate1(int[] nums, int k) {
        int n = k % nums.length;
        for (int i = 0; i < n; i++) {
            int tmp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = tmp;
        }
    }

    // 1 ms (beats 49.65%) | 57,46 mb memory (beats 27.70%)
    public void rotate2(int[] nums, int k) {
        int n = k % nums.length;
        int[] tempArray = new int[n];
        int idx = 0;
        for (int i = nums.length - n; i < nums.length; i++) tempArray[idx++] = nums[i];
        for (int i = nums.length - 1 - n; i >= 0; i--) nums[i + n] = nums[i];
        for (int i = 0; i < n; i++) nums[i] = tempArray[i];
    }

    @ParameterizedTest(name = "nums={0}, k={1}, expected={2}")
    @MethodSource(value = "testInput")
    void testRotate1(int[] nums, int k, int[] expected) {
        rotate1(nums, k);
        CollectionTestUtils.assertArray(expected, nums);
    }

    @ParameterizedTest(name = "nums={0}, k={1}, expected={2}")
    @MethodSource(value = "testInput")
    void testRotate2(int[] nums, int k, int[] expected) {
        rotate2(nums, k);
        CollectionTestUtils.assertArray(expected, nums);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
                Arguments.of(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100})
        );
    }
}
