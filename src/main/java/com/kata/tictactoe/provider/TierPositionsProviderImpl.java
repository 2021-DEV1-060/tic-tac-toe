package com.kata.tictactoe.provider;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TierPositionsProviderImpl implements TierPositionsProvider{
    private final static List<Integer> FIRST_TIER_CANDIDATE_POSITIONS = List.of(5);
    private final static List<Integer> SECOND_TIER_CANDIDATE_POSITIONS = List.of(2, 4, 6, 8);
    //TODO: remove third-tier as it is currently not being used
    private final static List<Integer> THIRD_TIER_CANDIDATE_POSITIONS = List.of(1, 3, 7, 9);

    @Override
    public List<Integer> getFirstTierCandidatePositions() {
        return FIRST_TIER_CANDIDATE_POSITIONS;
    }

    @Override
    public List<Integer> getSecondTierCandidatePositions() {
        return SECOND_TIER_CANDIDATE_POSITIONS;
    }

    @Override
    public List<Integer> getThirdTierCandidatePositions() {
        return THIRD_TIER_CANDIDATE_POSITIONS;
    };
}
