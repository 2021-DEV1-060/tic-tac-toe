package com.kata.tictactoe.verifier;

import com.kata.tictactoe.domain.Game;

public interface WinnerVerifier {
    boolean verifyIfWinnerExists(Game game);
}
