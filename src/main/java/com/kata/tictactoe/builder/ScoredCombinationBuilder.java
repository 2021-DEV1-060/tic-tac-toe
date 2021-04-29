package com.kata.tictactoe.builder;

import com.kata.tictactoe.domain.ScoredCombination;
import com.kata.tictactoe.enums.Shape;

import java.util.Set;

public interface ScoredCombinationBuilder {
    ScoredCombination<Integer> build(Shape opponentsShape, Shape playersShape, Shape[] state, Set<Integer> combination);
}
