package com.kata.tictactoe.registry;

import com.kata.tictactoe.domain.Player;
import com.kata.tictactoe.enums.Shape;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.kata.tictactoe.enums.Shape.BLANK;

@Slf4j
@Getter
@Component
public class StepRegistryImpl implements StepRegistry{
    private int stepCount;
    @Override
    public void registerStep(Player player, int desiredIndex, Shape[] state) {
        if (state == null) {
            log.debug("[registerStep] State is null");
            return;
        }
        if (desiredIndex < 0 || desiredIndex > state.length || positionIsTaken(desiredIndex, state)) {
            log.error("[registerStep]  Index {} attempted by {} is invalid.", desiredIndex, player.getPlayerType());
            return;
        }

        state[desiredIndex] = player.getShape();
        stepCount++;
    }

    private boolean positionIsTaken(int position, Shape[] state) {
        return state[position] != BLANK;
    }
}
