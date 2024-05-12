package com.code.leet;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 68. Text Justification - HARD
public class TextJustificationLeetCodeTest {

    public static class LineData {

        private final String line;

        public LineData(List<String> words, int maxWidth, boolean isLastLine) {
            String line;
            if (words.size() == 1) {
                line = justifyLeft(words, maxWidth);
            } else if (isLastLine) {
                line = justifyLeft(words, maxWidth);
            } else {
                line = justify(words, maxWidth);
            }
            this.line = line.toString();
        }

        private String justifyLeft(List<String> words, int maxWidth) {
            int width = words.stream().mapToInt(String::length).sum() + words.size() - 1;
            int repeat = Math.max(0, maxWidth - width);
            return String.join(" ", words) + " ".repeat(repeat);
        }

        private String justify(List<String> words, int maxWidth) {
            int width = words.stream().mapToInt(String::length).sum();

            int spacesWidth = maxWidth - width;
            int spacesCount = words.size() - 1;
            int spaceWidth = spacesWidth / spacesCount;
            int remainingSpaceWidth = spacesWidth % spacesCount;

            int[] spaceCounter = new int[spacesCount];
            Arrays.fill(spaceCounter, spaceWidth);
            for (int i = 0; i < remainingSpaceWidth; i++) spaceCounter[i]++;

            List<String> spaces = new ArrayList<>();
            for (int counter : spaceCounter) spaces.add(" ".repeat(counter));
            spaces.add("");

            StringBuilder line = new StringBuilder();
            for (int i = 0; i < words.size(); i++) {
                line.append(words.get(i));
                line.append(spaces.get(i));
            }

            return line.toString();
        }

        public String getLine() {
            return line;
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int idx = 0;
        List<LineData> lines = new ArrayList<>();
        List<String> lineWords = new ArrayList<>();
        while (idx < words.length) {
            lineWords.clear();
            int width = 0;
            while (idx < words.length && ((lineWords.isEmpty() && words[idx].length() == maxWidth) || width + 1 + words[idx].length() <= maxWidth)) {
                if (!lineWords.isEmpty()) width += 1;
                String word = words[idx++];
                width += word.length();
                lineWords.add(word);
            }
            lines.add(new LineData(lineWords, maxWidth, idx >= words.length));
        }

        return lines.stream().map(LineData::getLine).toList();
    }

    @Test
    void test1() {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        List<String> output = fullJustify(words, maxWidth);

        List<String> expectedResults = List.of(
                "This    is    an",
                "example  of text",
                "justification.  "
        );
        assertList(expectedResults, output);
    }

    @Test
    void test2() {
        String[] words = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;

        List<String> output = fullJustify(words, maxWidth);

        List<String> expectedResults = List.of(
                "What   must   be",
                "acknowledgment  ",
                "shall be        "
        );
        assertList(expectedResults, output);
    }

    @Test
    void test3() {
        String[] words = new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth = 20;

        List<String> output = fullJustify(words, maxWidth);

        List<String> expectedResults = List.of(
                "Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  "
        );
        assertList(expectedResults, output);
    }

    @Test
    void test4() {
        String[] words = new String[]{"Listen","to","many,","speak","to","a","few."};
        int maxWidth = 6;

        List<String> output = fullJustify(words, maxWidth);

        List<String> expectedResults = List.of(
                "Listen",
                "to    ",
                "many, ",
                "speak ",
                "to   a",
                "few.  "
        );
        assertList(expectedResults, output);
    }

    @Test
    void test5() {
        String[] words = new String[]{"a","b","c","d","e"};
        int maxWidth = 1;

        List<String> output = fullJustify(words, maxWidth);

        List<String> expectedResults = List.of(
                "a","b","c","d","e"
        );
        assertList(expectedResults, output);
    }

    private static void assertList(List<String> expected, List<String> actual) {
        if (expected == null && actual == null) return;
        if (expected == null)
            throw new AssertionFailedError("Lists are not the same", expected, actual);
        if (actual == null)
            throw new AssertionFailedError("Lists are not the same", expected, actual);
        if (expected.size() != actual.size())
            throw new AssertionFailedError("Lists are different in size", expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).equals(actual.get(i))) {
                throw new AssertionFailedError("Lists are not the same", expected, actual);
            }
        }
    }

}
