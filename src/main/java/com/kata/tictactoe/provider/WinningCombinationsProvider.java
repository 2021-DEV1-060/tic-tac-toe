package com.kata.tictactoe.provider;

import java.util.Set;

public interface WinningCombinationsProvider {
    Set<Set<Integer>> getWinningCombinations();
}
