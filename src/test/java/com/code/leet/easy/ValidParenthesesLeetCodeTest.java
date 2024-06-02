package com.code.leet.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Stream;

public class ValidParenthesesLeetCodeTest {

    private static final Set<Character> OPEN_BRACKETS = Set.of('{', '[', '(');
    private static final Map<Character, Character> CLOSING_BRACKETS = Map.of(
            '}', '{',
            ']', '[',
            ')', '('
    );

    public boolean isValid(String characters) {
        if (characters == null || characters.isEmpty()) return false;

        Stack<Character> parentheses = new Stack<>();
        for (int i = 0; i < characters.length(); i++) {
            char currentCharacter = characters.charAt(i);
            if (OPEN_BRACKETS.contains(currentCharacter)) {
                parentheses.push(currentCharacter);
            } else if (!parentheses.isEmpty()) {
                char lastCharacter = parentheses.pop();
                Character openBracket = CLOSING_BRACKETS.get(currentCharacter);
                if (!openBracket.equals(lastCharacter)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return parentheses.isEmpty();
    }

    @ParameterizedTest(name = "string={0}, expectedResult={1}")
    @MethodSource("testInput")
    void test(String string, boolean expectedResult) {
        boolean valid = isValid(string);
        Assertions.assertEquals(expectedResult, valid);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("]", false)
        );
    }

}
