package com.kata.tictactoe.provider;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class WinningCombinationsProviderImpl implements WinningCombinationsProvider{
    private static final Set<Set<Integer>> WINNING_COMBINATIONS = Set.of(
            Set.of(1, 2, 3),
            Set.of(4, 5, 6),
            Set.of(7, 8, 9),
            Set.of(1, 4, 7),
            Set.of(2, 5, 8),
            Set.of(3, 6, 9),
            Set.of(1, 5, 9),
            Set.of(3, 5, 7)
    );

    @Override
    public Set<Set<Integer>> getWinningCombinations() {
        return WINNING_COMBINATIONS;
    }
}
