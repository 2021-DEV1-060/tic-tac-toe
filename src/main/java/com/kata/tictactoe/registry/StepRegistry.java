package com.kata.tictactoe.registry;

import com.kata.tictactoe.domain.Player;
import com.kata.tictactoe.enums.Shape;

public interface StepRegistry {
    void registerStep(Player player, int position, Shape[] state);
    int getStepCount();
}
