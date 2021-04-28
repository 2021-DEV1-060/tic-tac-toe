package com.kata.tictactoe.engine;

import com.kata.tictactoe.domain.Player;
import com.kata.tictactoe.enums.Shape;
import com.kata.tictactoe.provider.CandidatePositionsProvider;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.kata.tictactoe.enums.Shape.BLANK;

@Component
public class NextStepCalculatorImpl implements NextStepCalculator{
    private CandidatePositionsProvider candidatePositionsProvider;

    @Override
    public int calculateNextStep(Player player, Shape[] state) {
        Set<Integer> blankPositions = findBlankPositions(state);

        Shape playersShape = player.getShape();

    }

    private Set<Integer> findBlankPositions(Shape[] state) {
        List<Shape> stateAsList = Arrays.asList(state);
        return Arrays.stream(state)
                .filter(BLANK::equals)
                .map(stateAsList::indexOf)
                .collect(Collectors.toSet());
    }
}
