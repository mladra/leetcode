package com.code.leet.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.Arrays;

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

    @Test
    void test1() {
        int[] array = new int[] { 3, 2, 2, 3 };
        int val = 3;

        int k = removeElement(array, val);
        Assertions.assertEquals(2, k);
        int[] differentNumbers = subArray(array, k);
        Arrays.sort(differentNumbers);
        assertArray(new int[] { 2, 2 }, differentNumbers);
    }

    @Test
    void test2() {
        int[] array = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val = 2;

        int k = removeElement(array, val);
        Assertions.assertEquals(5, k);
        int[] differentNumbers = subArray(array, k);
        Arrays.sort(differentNumbers);
        assertArray(new int[] { 0, 0, 1, 3, 4 }, differentNumbers);
    }

    @Test
    void test3() {
        int[] array = new int[] { 1 };
        int val = 1;

        int k = removeElement(array, val);
        Assertions.assertEquals(0, k);
        int[] differentNumbers = subArray(array, k);
        Arrays.sort(array, 0, k);
        assertArray(new int[0], differentNumbers);
    }

    @Test
    void test4() {
        int[] array = new int[] { 3, 3 };
        int val = 3;

        int k = removeElement(array, val);
        Assertions.assertEquals(0, k);
        int[] differentNums = subArray(array, k);
        Arrays.sort(array, 0, k);
        assertArray(new int[0], differentNums);
    }

    private static void assertArray(int[] expected, int[] actual) {
        if (expected == null && actual == null) return;
        if (expected == null) throw new AssertionFailedError("Arrays are not the same", Arrays.toString(expected), Arrays.toString(actual));
        if (actual == null) throw new AssertionFailedError("Arrays are not the same", Arrays.toString(expected), Arrays.toString(actual));
        if (expected.length != actual.length) throw new AssertionFailedError("Arrays are different in size", expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                throw new AssertionFailedError("Arrays are not the same", Arrays.toString(expected), Arrays.toString(actual));
            }
        }
    }

    private static int[] subArray(int[] array, int toIndexExcluded) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (toIndexExcluded >= array.length) {
            throw new IllegalArgumentException("Index exceeds arrays size");
        }
        int[] result = new int[toIndexExcluded];
        System.arraycopy(array, 0, result, 0, toIndexExcluded);
        return result;
    }

}
