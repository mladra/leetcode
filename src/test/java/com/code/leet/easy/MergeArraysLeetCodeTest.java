package com.code.leet.easy;

import com.code.leet.utils.CollectionTestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

    @ParameterizedTest(name = "nums1={0}, m={1}, nums2={2}, n={3}")
    @MethodSource("testInput")
    void test(int[] nums1, int m, int[] nums2, int n, int[] expectedArray) {
        merge(nums1, m, nums2, n);
        CollectionTestUtils.assertArray(expectedArray, nums1);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6}),
                Arguments.of(new int[]{1}, 1, new int[0], 0, new int[]{1}),
                Arguments.of(new int[]{0}, 0, new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 5, new int[0], 0, new int[]{1, 2, 3, 4, 5})
        );
    }

}
