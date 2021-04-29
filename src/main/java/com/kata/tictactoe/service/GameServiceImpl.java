package com.kata.tictactoe.service;

import com.kata.tictactoe.builder.GameDTOBuilder;
import com.kata.tictactoe.builder.PlayerBuilder;
import com.kata.tictactoe.domain.Game;
import com.kata.tictactoe.domain.Player;
import com.kata.tictactoe.dto.GameDTO;
import com.kata.tictactoe.engine.NextStepCalculator;
import com.kata.tictactoe.enums.PlayerType;
import com.kata.tictactoe.registry.StepRegistry;
import com.kata.tictactoe.verifier.WinnerVerifier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.kata.tictactoe.enums.PlayerType.CPU;
import static com.kata.tictactoe.enums.PlayerType.USER;

@Slf4j
@Component
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{
    private final Game game;
    private final GameDTOBuilder gameDTOBuilder;
    private final NextStepCalculator nextStepCalculator;
    private final PlayerBuilder playerBuilder;
    private final StepRegistry stepRegistry;
    private final WinnerVerifier winnerVerifier;

    @Override
    public GameDTO updateGame(PlayerType playerType, int desiredPosition) {
        Player currentPlayer = findPlayer(playerType);
        if (USER.equals(playerType)) {
            stepRegistry.registerStep(currentPlayer, desiredPosition-1, game.getState());
        }
        Player theCPU = findPlayer(CPU);
        int cPUsStep = nextStepCalculator.calculateNextStep(theCPU, game.getState());
        log.info("[updateGame] CPU has chosen index {}", cPUsStep);
        stepRegistry.registerStep(theCPU, cPUsStep, game.getState());
        winnerVerifier.verifyIfWinnerExists(game);
        return gameDTOBuilder.build(game);
    }

    @Override
    public GameDTO setUp(boolean userGoesFirst) {
        game.setPlayers(playerBuilder.buildPlayers(userGoesFirst));
        if (!userGoesFirst) {
            Player theCPU = findPlayer(CPU);
            if (theCPU == null) {
                log.error("[setUp] the CPU is not present.");
                return null;
            }
            return updateGame(CPU, nextStepCalculator.calculateNextStep(theCPU, game.getState()));
        }
        return gameDTOBuilder.build(game);
    }

    private Player findPlayer(PlayerType playerType) {
        return game.getPlayers().stream()
                .filter(player -> playerType.equals(player.getPlayerType()))
                .findFirst().orElse(null);
    }
}
