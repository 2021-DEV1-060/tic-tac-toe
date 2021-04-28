package com.kata.tictactoe.domain;

import com.kata.tictactoe.enums.Symbol;
import com.kata.tictactoe.enums.PlayerType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Player {
    private final PlayerType playerType;
    private final Symbol symbol;
}
