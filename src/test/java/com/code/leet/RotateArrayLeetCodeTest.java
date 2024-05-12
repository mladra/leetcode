package com.code.leet;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 189. Rotate Array
public class RotateArrayLeetCodeTest {

    public void rotate(int[] nums, int k) {
        int n = k % nums.length;
        for (int i = 0; i < n; i++) {
            int tmp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j+1] = nums[j];
            }
            nums[0] = tmp;
        }
    }

    @Test
    void test1() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        assertArray(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);
    }

    @Test
    void test2() {
        int[] nums = new int[]{-1, -100, 3, 99};
        int k = 2;
        rotate(nums, k);
        assertArray(new int[]{3, 99, -1, -100}, nums);
    }

    private static void assertArray(int[] expected, int[] actual) {
        if (expected == null && actual == null) return;
        if (expected == null)
            throw new AssertionFailedError("Arrays are not the same", Arrays.toString(expected), Arrays.toString(actual));
        if (actual == null)
            throw new AssertionFailedError("Arrays are not the same", Arrays.toString(expected), Arrays.toString(actual));
        if (expected.length != actual.length)
            throw new AssertionFailedError("Arrays are different in size", expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                throw new AssertionFailedError("Arrays are not the same", Arrays.toString(expected), Arrays.toString(actual));
            }
        }
    }
}
