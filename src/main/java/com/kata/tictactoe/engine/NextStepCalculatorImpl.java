package com.kata.tictactoe.engine;

import com.kata.tictactoe.domain.Player;
import com.kata.tictactoe.enums.Shape;
import com.kata.tictactoe.provider.TierPositionsProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.kata.tictactoe.enums.Shape.BLANK;

@Slf4j
@Component
@RequiredArgsConstructor
public class NextStepCalculatorImpl implements NextStepCalculator{
    private final TierPositionsProvider tierPositionsProvider;

    @Override
    //TODO: rename method
    public int calculateNextStep(Player player, Shape[] state) {
        Shape playersShape = player.getShape();
        //need to find starting position first
        if(!Arrays.asList(state).contains(playersShape)) {
            int startingPosition = findStartingPosition(state);
            if (startingPosition < 0) {
                log.error("[calculateNextStep] Starting position could not be determined.");
            }
            return startingPosition;
        }
        //TODO: make subsequent steps

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

    private int findSubsequentStep() {

    }
}
