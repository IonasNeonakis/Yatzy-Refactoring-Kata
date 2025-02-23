package org.codingdojo.yatzy3.strategies;

import org.codingdojo.yatzy3.ScorerStrategy;

import java.util.List;

public class TwoPairsScorerStrategy implements ScorerStrategy {
    @Override
    public int calculateScore(List<Integer> dice) {
        var frequencies = frequencies(dice);
        if (frequencies(dice).values().stream().filter(die -> die >= 2).toList().size() != 2) {
            return 0;
        }

        return DICE_VALUES.stream()
            .mapToInt(Integer::intValue)
            .filter(die -> frequencies.get(die) >= 2)
            .sum() * 2;
    }
}
