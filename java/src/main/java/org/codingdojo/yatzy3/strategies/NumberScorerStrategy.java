package org.codingdojo.yatzy3.strategies;

import org.codingdojo.yatzy3.ScorerStrategy;

import java.util.List;

public class NumberScorerStrategy implements ScorerStrategy {
    private final int number;

    public NumberScorerStrategy(int number) {
        this.number = number;
    }

    @Override
    public int calculateScore(List<Integer> dice) {
        return frequencies(dice).get(number) * number;
    }
}
