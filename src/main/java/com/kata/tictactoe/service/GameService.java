package com.kata.tictactoe.service;

import com.kata.tictactoe.dto.GameDTO;
import com.kata.tictactoe.enums.PlayerType;

public interface GameService {
    GameDTO updateGame(PlayerType playerType, int desiredPosition);
    GameDTO setUp(boolean userGoesFirst);
}
