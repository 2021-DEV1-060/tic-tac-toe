package com.kata.tictactoe.domain;

import com.kata.tictactoe.enums.PlayerType;
import com.kata.tictactoe.enums.Shape;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
//TODO: these instances should built by a builder class - not to be configured by the container
public class Player {
    private final PlayerType playerType;
    private final Shape shape;
}
