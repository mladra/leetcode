package com.code.leet.utils;

import org.opentest4j.AssertionFailedError;

import java.util.Arrays;
import java.util.List;

public final class CollectionTestUtils {

    private CollectionTestUtils() {
        throw new IllegalStateException("Cannot create instance of class " + getClass().getSimpleName());
    }

    public static void assertArray(int[] expected, int[] actual) {
        if (expected == null && actual == null) {
            return;
        }
        if (expected == null || actual == null) {
            throw new AssertionFailedError("Arrays are not the same", Arrays.toString(expected), Arrays.toString(actual));
        }
        if (expected.length != actual.length) {
            throw new AssertionFailedError("Arrays are different in size", expected.length, actual.length);
        }
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                throw new AssertionFailedError("Arrays are not the same", Arrays.toString(expected), Arrays.toString(actual));
            }
        }
    }

    public static int[] subArray(int[] array, int toIndexExcluded) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (toIndexExcluded > array.length) {
            throw new IllegalArgumentException("Index exceeds arrays size");
        }
        int[] result = new int[toIndexExcluded];
        System.arraycopy(array, 0, result, 0, toIndexExcluded);
        return result;
    }

    public static void assertList(List<String> expected, List<String> actual) {
        if (expected == null && actual == null) return;
        if (expected == null || actual == null) {
            throw new AssertionFailedError("Lists are not the same", expected, actual);
        }
        if (expected.size() != actual.size()) {
            throw new AssertionFailedError("Lists are different in size", expected.size(), actual.size());
        }
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).equals(actual.get(i))) {
                throw new AssertionFailedError("Lists are not the same", expected, actual);
            }
        }
    }

}
