package com.kata.tictactoe.verifier;

import com.kata.tictactoe.domain.Game;
import com.kata.tictactoe.domain.Player;
import com.kata.tictactoe.enums.Shape;
import com.kata.tictactoe.provider.WinningCombinationsProvider;
import com.kata.tictactoe.registry.StepRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.kata.tictactoe.enums.Shape.BLANK;

@Slf4j
@Component
@RequiredArgsConstructor
public class WinnerVerifierImpl implements WinnerVerifier{
    private final StepRegistry stepRegistry;
    private final WinningCombinationsProvider winningCombinationsProvider;

    @Override
    public boolean verifyIfWinnerExists(Game game) {
        Shape[] state = game.getState();
        if (state == null) {
            log.error("[verifyIfWinnerExists] Game has no state");
            return false;
        }
        if (stepRegistry.getStepCount() < 5) {
            return false;
        }

        return getShapesInGameWithoutBlank(state).stream()
                .anyMatch(shape -> winnerShapeExists(shape, state, game));
    }

    private boolean winnerShapeExists(Shape shape, Shape[] state, Game game) {
        Set<Integer> positionsPerShape = new HashSet<>();
        Arrays.asList(state).forEach(shapeInState -> {
            if (shape.equals(shapeInState)) {
                Integer index = Arrays.asList(state).indexOf(shape);
                positionsPerShape.add(index);
            }
        });
        setWinnerIfWinningCombinationExists(positionsPerShape, shape, game);
        return game.getWinner() != null;
    }

    private void setWinnerIfWinningCombinationExists(Set<Integer> positionsPerShape, Shape shape, Game game) {
        if(winningCombinationsProvider.getWinningCombinations().contains(positionsPerShape)) {
            Player winner = findWinner(shape, game);
            game.setWinner(winner);
        }
    }

    private Player findWinner(Shape shape, Game game) {
        return game.getPlayers().stream()
                .filter(player -> shape.equals(player.getShape()))
                .findFirst().orElse(null);
    }

    private Set<Shape> getShapesInGameWithoutBlank(Shape[] state) {
        return Arrays.stream(state)
                .filter(shape -> !shape.equals(BLANK)
                )
                .collect(Collectors.toSet());
    }
}
