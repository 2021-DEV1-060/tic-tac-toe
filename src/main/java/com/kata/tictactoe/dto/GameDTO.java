package com.kata.tictactoe.dto;

import com.kata.tictactoe.domain.Player;
import com.kata.tictactoe.enums.Shape;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class GameDTO {
    private final Set<Player> players;
    private final Player winner;
    private final Shape[] state;
    private final String stateView;
}
