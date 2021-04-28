package com.kata.tictactoe.provider;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CandidatePositionsProviderImpl implements CandidatePositionsProvider{
    private final static Set<Integer> FIRST_TIER_CANDIDATE_POSITIONS = Set.of(5);
    private final static Set<Integer> SECOND_TIER_CANDIDATE_POSITIONS = Set.of(2, 4, 6, 8);
    private final static Set<Integer> THIRD_TIER_CANDIDATE_POSITIONS = Set.of(1, 3, 7, 9);

    @Override
    public Set<Integer> getFirstTierCandidatePositions() {
        return FIRST_TIER_CANDIDATE_POSITIONS;
    }

    @Override
    public Set<Integer> getSecondTierCandidatePositions() {
        return SECOND_TIER_CANDIDATE_POSITIONS;
    }

    @Override
    public Set<Integer> getThirdTierCandidatePositions() {
        return THIRD_TIER_CANDIDATE_POSITIONS;
    };
}
