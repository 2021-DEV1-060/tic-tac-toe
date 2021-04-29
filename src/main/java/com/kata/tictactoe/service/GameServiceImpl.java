package com.kata.tictactoe.service;

import com.kata.tictactoe.builder.PlayerBuilder;
import com.kata.tictactoe.domain.Game;
import com.kata.tictactoe.domain.Player;
import com.kata.tictactoe.engine.NextStepCalculator;
import com.kata.tictactoe.enums.PlayerType;
import com.kata.tictactoe.registry.StepRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.kata.tictactoe.enums.PlayerType.CPU;

@Slf4j
@Component
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{
    private final Game game;
    private final NextStepCalculator nextStepCalculator;
    private final PlayerBuilder playerBuilder;
    private final StepRegistry stepRegistry;

    @Override
    public Game play(PlayerType playerType, int desiredPosition) {
        Player currentPlayer = findCurrentPlayer(playerType);
        if (CPU.equals(playerType)) {
            int cPUsStep = nextStepCalculator.calculateNextStep(currentPlayer, game.getState());
            stepRegistry.registerStep(currentPlayer, cPUsStep, game.getState());
        }
        stepRegistry.registerStep(currentPlayer, desiredPosition, game.getState());
        return game;
    }

    @Override
    public Game setUp(boolean userGoesFirst) {
        game.setPlayers(playerBuilder.buildPlayers(userGoesFirst));
        if (!userGoesFirst) {
            Player theCPU = findCurrentPlayer(CPU);
            if (theCPU == null) {
                log.error("[setUp] the CPU is not present.");
                return null;
            }
            return play(CPU, nextStepCalculator.calculateNextStep(theCPU, game.getState()));
        }
        return game;
    }

    private Player findCurrentPlayer(PlayerType playerType) {
        return game.getPlayers().stream()
                .filter(player -> playerType.equals(player.getPlayerType()))
                .findFirst().orElse(null);
    }
}
