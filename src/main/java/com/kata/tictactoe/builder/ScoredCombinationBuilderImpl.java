package com.kata.tictactoe.builder;

import com.kata.tictactoe.domain.ScoredCombination;
import com.kata.tictactoe.enums.Shape;
import com.kata.tictactoe.scorer.WinningCombinationScorer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class ScoredCombinationBuilderImpl implements ScoredCombinationBuilder{
    private final WinningCombinationScorer winningCombinationScorer;

    @Override
    public ScoredCombination<Integer> build(Shape opponentsShape, Shape playersShape, Shape[] state, Set<Integer> combination) {
        return new ScoredCombination<>(combination,
                winningCombinationScorer.score(opponentsShape, playersShape, state, combination));
    }
}
