package com.kata.tictactoe.builder;

import com.kata.tictactoe.domain.Game;
import com.kata.tictactoe.dto.GameDTO;

public interface GameDTOBuilder {
    GameDTO build(Game game);
}
