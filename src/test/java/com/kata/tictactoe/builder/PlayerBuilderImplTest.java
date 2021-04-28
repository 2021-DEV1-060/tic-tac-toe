package com.kata.tictactoe.builder;

import com.kata.tictactoe.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.kata.tictactoe.enums.PlayerType.USER;
import static com.kata.tictactoe.enums.Shape.CIRCLE;
import static com.kata.tictactoe.enums.Shape.CROSS;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

class PlayerBuilderImplTest {
    private PlayerBuilder playerBuilder;

    @BeforeEach
    void init() {
        playerBuilder = new PlayerBuilderImpl();
    }

    @Test
    void testBuildPlayersWhenUserWantsToGoFirst() {
        Set<Player> players = playerBuilder.buildPlayers(true);
        players.forEach(player -> {
            assertThat(player, is(notNullValue()));
            assertThat(player.getShape(), (is(notNullValue())));
            assertThat(player.getPlayerType(), (is(notNullValue())));
            if (player.getPlayerType().equals(USER)) {
                assertThat(player.getShape(), is(CROSS));
            }
        });
    }

    @Test
    void testBuildPlayersWhenUserWantsToGoSecond() {
        Set<Player> players = playerBuilder.buildPlayers(false);
        players.forEach(player -> {
            assertThat(player, is(notNullValue()));
            assertThat(player.getShape(), (is(notNullValue())));
            assertThat(player.getPlayerType(), (is(notNullValue())));
            if (player.getPlayerType().equals(USER)) {
                assertThat(player.getShape(), is(CIRCLE));
            }
        });
    }
}
