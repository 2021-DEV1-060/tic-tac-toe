package com.kata.tictactoe.provider;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TierPositionsProviderImpl implements TierPositionsProvider{
    private final static List<Integer> FIRST_TIER_CANDIDATE_POSITIONS = List.of(5);
    private final static List<Integer> SECOND_TIER_CANDIDATE_POSITIONS = List.of(2, 4, 6, 8);

    @Override
    public List<Integer> getFirstTierCandidatePositions() {
        return FIRST_TIER_CANDIDATE_POSITIONS;
    }

    @Override
    public List<Integer> getSecondTierCandidatePositions() {
        return SECOND_TIER_CANDIDATE_POSITIONS;
    }
}
