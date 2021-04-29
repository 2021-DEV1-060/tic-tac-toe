package com.kata.tictactoe.scorer;

import com.kata.tictactoe.enums.Shape;

import java.util.Set;

public interface WinningCombinationScorer {
    int score(Shape opponentsShape, Shape playersShape, Shape[] state, Set<Integer> combination);
}
