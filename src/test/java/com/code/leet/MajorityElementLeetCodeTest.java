package com.code.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    @Test
    void test1() {
        int[] nums = new int[]{3, 2, 3};
        int element = majorityElement(nums);
        Assertions.assertEquals(3, element);
    }

    @Test
    void test2() {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int element = majorityElement(nums);
        Assertions.assertEquals(2, element);
    }

    @Test
    void test3() {
        int[] nums = new int[]{1};
        int element = majorityElement(nums);
        Assertions.assertEquals(1, element);
    }

}
