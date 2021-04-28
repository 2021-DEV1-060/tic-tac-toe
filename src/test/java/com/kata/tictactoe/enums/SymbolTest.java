package com.kata.tictactoe.enums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class SymbolTest {

    private static Stream<Arguments> values() {
        return Stream.of(
                Arguments.of(Symbol.BLANK, " "),
                Arguments.of(Symbol.CIRCLE, "O"),
                Arguments.of(Symbol.CROSS, "X")
                );
    }

    @MethodSource("values")
    @ParameterizedTest
    void testValues(Symbol symbol, String expectedAnswer) {
        assertThat(symbol.getValue(), is(expectedAnswer));
    }
}
