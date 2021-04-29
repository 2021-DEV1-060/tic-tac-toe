package com.kata.tictactoe.registry;

import com.kata.tictactoe.domain.Player;
import com.kata.tictactoe.enums.Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.kata.tictactoe.enums.PlayerType.USER;
import static com.kata.tictactoe.enums.Shape.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class StepRegistryImplTest {
    private static final Shape[] TEST_STATE = new Shape[] {CIRCLE};
    private StepRegistry stepRegistry;

    private static Stream<Arguments> parametersWithNullState() {
        return Stream.of(
                Arguments.of(new Player(USER, CROSS), 0, null, null));
    }

    private static Stream<Arguments> parametersWithInvalidPosition() {
        return Stream.of(
                Arguments.of(new Player(USER, CROSS), -1, TEST_STATE, CIRCLE),
                Arguments.of(new Player(USER, CROSS), 0, TEST_STATE, CIRCLE));
    }

    private static Stream<Arguments> parametersWithoutError() {
        return Stream.of(
                Arguments.of(new Player(USER, CROSS), 0, new Shape[] {BLANK}));
    }

    @BeforeEach
    void init() {
        stepRegistry = new StepRegistryImpl();
    }

    @MethodSource("parametersWithNullState")
    @ParameterizedTest
    void testRegisterStepWithNull(Player player, int position, Shape[] state, Shape expectedShape) {
        stepRegistry.registerStep(player, position, state);
        assertThat(state, is(expectedShape));
    }

    @MethodSource("parametersWithInvalidPosition")
    @ParameterizedTest
    void testRegisterStepWithError(Player player, int position, Shape[] state, Shape expectedShape) {
        stepRegistry.registerStep(player, position, state);
        assertThat(state, is(new Shape[]{expectedShape}));
    }

    @MethodSource("parametersWithoutError")
    @ParameterizedTest
    void testRegisterStepWithoutError(Player player, int position, Shape[] state) {
        stepRegistry.registerStep(player, position, state);
        assertThat(state, is(new Shape[]{player.getShape()}));
    }
}
