package com.code.leet.easy;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.Arrays;

// 88. Merge Sorted Array
public class MergeArraysLeetCodeTest {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Old = new int[m];
        System.arraycopy(nums1, 0, nums1Old, 0, m);

        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (idx1 >= m) {
                nums1[i] = nums2[idx2++];
                continue;
            }
            if (idx2 >= n) {
                nums1[i] = nums1Old[idx1++];
                continue;
            }
            if (nums1Old[idx1] < nums2[idx2]) {
                nums1[i] = nums1Old[idx1++];
            } else {
                nums1[i] = nums2[idx2++];
            }
        }
    }

    @Test
    void test1() {
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[] {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        assertArray(new int[] { 1, 2, 2, 3, 5, 6 }, nums1);
    }

    @Test
    void test2() {
        int[] nums1 = new int[] {1};
        int m = 1;
        int[] nums2 = new int[0];
        int n = 0;

        merge(nums1, m, nums2, n);

        assertArray(new int[] { 1 }, nums1);
    }

    @Test
    void test3() {
        int[] nums1 = new int[] {0};
        int m = 0;
        int[] nums2 = new int[] {1};
        int n = 1;

        merge(nums1, m, nums2, n);

        assertArray(new int[] { 1 }, nums1);
    }

    @Test
    void test4() {
        int[] nums1 = new int[] {1, 2, 3, 4, 5};
        int m = 5;
        int[] nums2 = new int[0];
        int n = 0;

        merge(nums1, m, nums2, n);

        assertArray(new int[] { 1, 2, 3, 4, 5 }, nums1);
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

}