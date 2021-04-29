package com.kata.tictactoe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class ScoredCombination<T> {
    private Set<T> combination;
    private int score;
}
