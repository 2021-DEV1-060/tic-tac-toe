package com.kata.tictactoe.enums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.kata.tictactoe.enums.Shape.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ShapeTest {

    private static Stream<Arguments> values() {
        return Stream.of(
                Arguments.of(BLANK, " "),
                Arguments.of(CIRCLE, "O"),
                Arguments.of(CROSS, "X")
                );
    }

    @MethodSource("values")
    @ParameterizedTest
    void testValues(Shape shape, String expectedAnswer) {
        assertThat(shape.getValue(), is(expectedAnswer));
    }

}
