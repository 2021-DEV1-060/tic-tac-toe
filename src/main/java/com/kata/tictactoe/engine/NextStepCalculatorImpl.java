package com.kata.tictactoe.engine;

import com.kata.tictactoe.builder.ScoredCombinationBuilder;
import com.kata.tictactoe.domain.Player;
import com.kata.tictactoe.domain.ScoredCombination;
import com.kata.tictactoe.enums.Shape;
import com.kata.tictactoe.provider.TierPositionsProvider;
import com.kata.tictactoe.provider.WinningCombinationsProvider;
import com.kata.tictactoe.comparator.ScoredCombinationComparator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static com.kata.tictactoe.enums.Shape.BLANK;

@Slf4j
@Component
@RequiredArgsConstructor
//TODO: remove log.info()'s once there are no bugs present
public class NextStepCalculatorImpl implements NextStepCalculator{
    private final ScoredCombinationBuilder scoredCombinationBuilder;
    private final TierPositionsProvider tierPositionsProvider;
    private final WinningCombinationsProvider winningCombinationsProvider;

    @Override
    public int calculateNextStep(Player player, Shape[] state) {
        Shape playersShape = player.getShape();
        if(!Arrays.asList(state).contains(playersShape)) {
            int startingPosition = findStartingPosition(state);
            if (startingPosition < 0) {
                log.error("[calculateNextStep] Starting position could not be determined.");
            }
            return startingPosition;
        }
        Shape opponentsShape = Arrays.stream(Shape.values())
                .filter(shape -> !shape.equals(playersShape)).findFirst().orElse(null);
        return findSubsequentStep(playersShape, opponentsShape, state);
    }

    private int findStartingPosition(Shape[] state) {
        Integer bestChoice = tierPositionsProvider.getFirstTierCandidatePositions().get(0);
        if (state[bestChoice].equals(BLANK)) {
            return bestChoice;
        }
        //TODO: Does this really need to be a list?
        List<Integer> secondTierOptions = tierPositionsProvider.getSecondTierCandidatePositions();

        return secondTierOptions.stream()
                .map(secondTierOption -> {
                    if (state[secondTierOption].equals(BLANK)) {
                        return secondTierOption;
                    }
                    return -1;
                })
                .filter(secondTierOption -> secondTierOption > -1)
                .findFirst().orElse(-1);
    }

    private int findSubsequentStep(Shape playersShape, Shape opponentsShape, Shape[] state) {
        if (opponentsShape == null) {
            log.error("[findSubsequentStep] Opponent's shape not found.");
            return -1;
        }

        List<Shape> stateAsList = Arrays.asList(state);

        Set<Integer> positionsWhereUsersShapeIsPresent = stateAsList.stream()
                .filter(shape -> shape.equals(playersShape))
                .map(stateAsList::indexOf)
                .collect(Collectors.toSet());


        log.info("[findSubsequentStep] positionsWhereUsersShapeIsPresent is {}", positionsWhereUsersShapeIsPresent);

        Set<Set<Integer>> winningCombinationsWhereUsersShapeIsPresent = positionsWhereUsersShapeIsPresent.stream()
                .map(usersPosition -> winningCombinationsProvider.getWinningCombinations().stream()
                            .filter(winningCombination -> winningCombination.contains(usersPosition))
                            .findFirst().orElse(Collections.emptySet()))
                .collect(Collectors.toSet());

        log.info("[findSubsequentStep] winningCombinationsWhereUsersShapeIsPresent is {}", winningCombinationsWhereUsersShapeIsPresent);

        Set<ScoredCombination<Integer>> scoredCombinations =
                winningCombinationsWhereUsersShapeIsPresent.stream()
                .map(combination -> scoredCombinationBuilder.build(opponentsShape, playersShape, state, combination))
                .collect(Collectors.toSet());
        log.info("[findSubsequentStep] scoredCombinations is {}", scoredCombinations);

        SortedSet<ScoredCombination<Integer>> sortedScoredCombinations = new TreeSet<>( new ScoredCombinationComparator());
        sortedScoredCombinations.addAll(scoredCombinations);

        ScoredCombination<Integer> selectedScoredCombination = sortedScoredCombinations.first();
        log.info("[findSubsequentStep] selectedScoredCombination is {}", selectedScoredCombination);

        return selectedScoredCombination.getCombination().stream()
                .filter(position -> state[position].equals(BLANK))
                .findFirst().orElse(-1);
    }
}
