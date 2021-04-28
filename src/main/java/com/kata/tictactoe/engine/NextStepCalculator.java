package com.kata.tictactoe.engine;

import com.kata.tictactoe.domain.Player;
import com.kata.tictactoe.enums.Shape;

public interface NextStepCalculator {
    int calculateNextStep(Player player, Shape[] state);
}
