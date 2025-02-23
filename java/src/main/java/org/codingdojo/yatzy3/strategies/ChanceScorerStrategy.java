package org.codingdojo.yatzy3.strategies;

import org.codingdojo.yatzy3.ScorerStrategy;

import java.util.List;

public class ChanceScorerStrategy implements ScorerStrategy {
    @Override
    public int calculateScore(List<Integer> dice) {
        return sum(dice);
    }
}
