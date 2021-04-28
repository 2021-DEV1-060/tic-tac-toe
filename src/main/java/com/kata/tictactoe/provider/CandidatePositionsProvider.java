package com.kata.tictactoe.provider;

import java.util.Set;

public interface CandidatePositionsProvider {
    Set<Integer> getFirstTierCandidatePositions();
    Set<Integer> getSecondTierCandidatePositions();
    Set<Integer> getThirdTierCandidatePositions();
}
