package org.codingdojo.yatzy3.strategies;

import org.codingdojo.yatzy3.ScorerStrategy;

import java.util.List;

public class RepeatedCountScorerStrategy implements ScorerStrategy {
    private final int count;

    public RepeatedCountScorerStrategy(int count) {
        this.count = count;
    }

    @Override
    public int calculateScore(List<Integer> dice) {
        var frequencies = frequencies(dice);
        for (var die : DICE_VALUES) {
            if (frequencies.get(die) >= count) {
                return die * count;
            }
        }
        return 0;
    }
}
