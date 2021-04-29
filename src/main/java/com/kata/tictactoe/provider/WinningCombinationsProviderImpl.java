package com.kata.tictactoe.provider;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class WinningCombinationsProviderImpl implements WinningCombinationsProvider{
    private static final Set<Set<Integer>> WINNING_COMBINATIONS = Set.of(
            Set.of(0, 1, 2),
            Set.of(3, 4, 5),
            Set.of(6, 7, 8),
            Set.of(0, 3, 6),
            Set.of(1, 4, 7),
            Set.of(2, 5, 8),
            Set.of(0, 4, 8),
            Set.of(2, 4, 6)
    );

    @Override
    public Set<Set<Integer>> getWinningCombinations() {
        return WINNING_COMBINATIONS;
    }
}
