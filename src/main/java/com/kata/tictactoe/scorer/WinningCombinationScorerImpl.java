package com.kata.tictactoe.scorer;

import com.kata.tictactoe.enums.Shape;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class WinningCombinationScorerImpl implements WinningCombinationScorer{
    public int score(Shape opponentsShape, Shape playersShape, Shape[] state, Set<Integer> combination) {
        List<Shape> combinationAsShapes = combination.stream()
                .map(position -> state[position])
                .collect(Collectors.toList());

        if (combinationAsShapes.contains(opponentsShape)) {
            return 0;
        }

        if (combinationAsShapes.containsAll(List.of(playersShape, playersShape))) {
            return 10;
        }

        if (combinationAsShapes.contains(playersShape)) {
            return 5;
        }

        return 0;
    }
}
