package com.kata.tictactoe.registry;

import com.kata.tictactoe.domain.Player;
import com.kata.tictactoe.enums.Shape;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.kata.tictactoe.enums.Shape.BLANK;

@Slf4j
@Component
public class StepRegistryImpl implements StepRegistry{
    public void registerStep(Player player, int position, Shape[] state) {
        if (state == null) {
            log.debug("State is null");
            return;
        }

        if (position < 0 || position > state.length || positionIsTaken(position, state)) {
            log.error("Position is invalid.");
            return;
        }

        state[position] = player.getShape();
    }

    private boolean positionIsTaken(int position, Shape[] state) {
        return state[position] != BLANK;
    }
}
