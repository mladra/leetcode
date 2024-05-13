package com.code.leet.easy;

import com.code.leet.utils.CollectionTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

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

    @ParameterizedTest(name = "nums={0}, expectedK={1}, expectedArray={2}")
    @MethodSource("testInput")
    void test(int[] nums, int expectedK, int[] expectedArray) {
        int k = removeDuplicates(nums);
        Assertions.assertEquals(expectedK, k);
        int[] differentNums = CollectionTestUtils.subArray(nums, k);
        CollectionTestUtils.assertArray(expectedArray, differentNums);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5, new int[]{0, 1, 2, 3, 4}),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1, 2}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{1, 1}, 1, new int[]{1}),
                Arguments.of(new int[]{-3, -1, 0, 0, 0, 3, 3}, 4, new int[]{-3, -1, 0, 3})
        );
    }
}
