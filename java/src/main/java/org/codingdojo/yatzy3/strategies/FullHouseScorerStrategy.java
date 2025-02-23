package org.codingdojo.yatzy3.strategies;

import org.codingdojo.yatzy3.ScorerStrategy;

import java.util.List;
import java.util.Map;

public class FullHouseScorerStrategy implements ScorerStrategy {
    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Integer> frequencies = frequencies(dice);
        if (frequencies.containsValue(2) && frequencies.containsValue(3)) {
            return sum(dice);
        }
        return 0;
    }
}
