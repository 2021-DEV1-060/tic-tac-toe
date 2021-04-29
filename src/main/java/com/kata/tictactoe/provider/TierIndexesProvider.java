package com.kata.tictactoe.provider;


import java.util.List;

public interface TierIndexesProvider {
    List<Integer> getFirstTierCandidatePositions();
    List<Integer> getSecondTierCandidatePositions();
}
