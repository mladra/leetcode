package com.code.leet.easy;

import com.code.leet.utils.CollectionTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

// 26. Remove Duplicates from Sorted Array
public class RemoveDuplicatesFromSortedArrayLeetCodeTest {

    // 3 ms (beats 10.69%) | 44.79 mb (beats 33.88%)
    public int removeDuplicates(int[] nums) {
        Set<Integer> unique = new LinkedHashSet<>();
        for (int num : nums) unique.add(num);
        Iterator<Integer> it = unique.iterator();
        int idx = 0;
        while (it.hasNext()) nums[idx++] = it.next();
        return unique.size();
    }

    @Test
    void test1() {
        int[] nums = new int[]{1, 1, 2};
        int k = removeDuplicates(nums);
        Assertions.assertEquals(2, k);
        int[] differentNums = CollectionTestUtils.subArray(nums, k);
        CollectionTestUtils.assertArray(new int[]{1, 2}, differentNums);
    }

    @Test
    void test2() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = removeDuplicates(nums);
        Assertions.assertEquals(5, k);
        int[] differentNums = CollectionTestUtils.subArray(nums, k);
        CollectionTestUtils.assertArray(new int[]{0, 1, 2, 3, 4}, differentNums);
    }

    @Test
    void test3() {
        int[] nums = new int[]{1};
        int k = removeDuplicates(nums);
        Assertions.assertEquals(1, k);
        int[] differentNums = CollectionTestUtils.subArray(nums, k);
        CollectionTestUtils.assertArray(new int[]{1}, differentNums);
    }

    @Test
    void test4() {
        int[] nums = new int[]{1, 2};
        int k = removeDuplicates(nums);
        Assertions.assertEquals(2, k);
        int[] differentNums = CollectionTestUtils.subArray(nums, k);
        CollectionTestUtils.assertArray(new int[]{1, 2}, differentNums);
    }

    @Test
    void test5() {
        int[] nums = new int[]{1, 1};
        int k = removeDuplicates(nums);
        Assertions.assertEquals(1, k);
        int[] differentNums = CollectionTestUtils.subArray(nums, k);
        CollectionTestUtils.assertArray(new int[]{1}, differentNums);
    }

    @Test
    void test6() {
        int[] nums = new int[]{-3, -1, 0, 0, 0, 3, 3};
        int k = removeDuplicates(nums);
        Assertions.assertEquals(4, k);
        int[] differentNums = CollectionTestUtils.subArray(nums, k);
        CollectionTestUtils.assertArray(new int[]{-3, -1, 0, 3}, differentNums);
    }
}
