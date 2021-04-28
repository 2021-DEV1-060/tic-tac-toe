package com.kata.tictactoe.builder;

import com.kata.tictactoe.domain.Player;

import java.util.Set;

public interface PlayerBuilder {
    Set<Player> buildPlayers(boolean userWantsToGoFirst);
}
