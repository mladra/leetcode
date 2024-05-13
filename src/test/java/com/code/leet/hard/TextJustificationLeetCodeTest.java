package com.code.leet.hard;

import com.code.leet.utils.CollectionTestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// 68. Text Justification
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

    @ParameterizedTest(name = "word={0}, maxWidth={1}, expectedLines={2}")
    @MethodSource("testInput")
    void test(String[] words, int maxWidth, List<String> expectedLines) {
        List<String> output = fullJustify(words, maxWidth);
        CollectionTestUtils.assertList(expectedLines, output);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16, List.of("This    is    an", "example  of text", "justification.  ")),
                Arguments.of(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16, List.of("What   must   be", "acknowledgment  ", "shall be        ")),
                Arguments.of(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20, List.of("Science  is  what we", "understand      well", "enough to explain to", "a  computer.  Art is", "everything  else  we", "do                  ")),
                Arguments.of(new String[]{"Listen", "to", "many,", "speak", "to", "a", "few."}, 6, List.of("Listen", "to    ", "many, ", "speak ", "to   a", "few.  ")),
                Arguments.of(new String[]{"a", "b", "c", "d", "e"}, 1, List.of("a", "b", "c", "d", "e"))
        );
    }

}
