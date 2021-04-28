package com.kata.tictactoe.enums.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Symbol {
    CIRCLE("O"),
    CROSS("X"),
    BLANK(" ");

    private final String value;
}
