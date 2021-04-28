package com.kata.tictactoe.enums.domain;

import com.kata.tictactoe.enums.enums.PlayerType;
import com.kata.tictactoe.enums.enums.Symbol;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Player {
    private final PlayerType playerType;
    private final Symbol symbol;
}
