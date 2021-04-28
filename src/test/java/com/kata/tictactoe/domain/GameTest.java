package com.kata.tictactoe.domain;

import com.kata.tictactoe.enums.Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.kata.tictactoe.enums.Shape.BLANK;
import static com.kata.tictactoe.enums.Shape.CIRCLE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

class GameTest {
    private Game game;

    @BeforeEach
    void init() {
        game = new Game();
    }

    @Test
    void verifyGameStatesInitialContent() {
        List.of(game.getState()).forEach(e -> {
            assertThat(e, is(notNullValue()));
            assertThat(e, is(BLANK));
            assertThat(game.getState().length, is(6));
        });
    }
}
