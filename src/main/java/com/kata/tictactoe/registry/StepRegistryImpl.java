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
    public void registerStep(Player player, int desiredPosition, Shape[] state) {
        if (state == null) {
            log.debug("[registerStep] State is null");
            return;
        }

        if (desiredPosition < 0 || desiredPosition > state.length || positionIsTaken(desiredPosition, state)) {
            log.error("[registerStep]  Position is invalid.");
            return;
        }

        state[desiredPosition] = player.getShape();
        stepCount++;
    }

    private boolean positionIsTaken(int position, Shape[] state) {
        return state[position] != BLANK;
    }
}
