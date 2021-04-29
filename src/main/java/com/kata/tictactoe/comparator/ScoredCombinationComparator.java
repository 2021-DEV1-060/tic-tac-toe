package com.kata.tictactoe.comparator;

import com.kata.tictactoe.domain.ScoredCombination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
@RequiredArgsConstructor
public class ScoredCombinationComparator implements Comparator<ScoredCombination<Integer>> {
    @Override
    public int compare(ScoredCombination<Integer> scoredCombination1, ScoredCombination<Integer> scoredCombination2) {
        return scoredCombination2.getScore() - scoredCombination1.getScore();
    }
}
