package com.kata.tictactoe.provider;


import java.util.List;

public interface TierPositionsProvider {
    List<Integer> getFirstTierCandidatePositions();
    List<Integer> getSecondTierCandidatePositions();
}
