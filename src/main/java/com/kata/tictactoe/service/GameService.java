package com.kata.tictactoe.service;

import com.kata.tictactoe.domain.Game;
import com.kata.tictactoe.enums.PlayerType;

public interface GameService {
    Game play(PlayerType playerType, int desiredPosition);
    Game setUp(boolean userGoesFirst);
}
