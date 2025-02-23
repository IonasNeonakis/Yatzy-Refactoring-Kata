package org.codingdojo.yatzy3.strategies;

import org.codingdojo.StraightType;
import org.codingdojo.yatzy3.ScorerStrategy;

import java.util.List;

public class StraightScorerStrategy implements ScorerStrategy {
    private final StraightType straightType;

    public StraightScorerStrategy(StraightType straightType) {
        this.straightType = straightType;
    }

    @Override
    public int calculateScore(List<Integer> dice) {
        if (isStraight(dice) && frequencies(dice).get(straightType.getMissingDiceValue()) == 0) {
            return sum(dice);
        }
        return 0;
    }

    private boolean isStraight(List<Integer> dice) {
        return frequencies(dice).values().stream().filter(die -> die == 1).toList().size() == 5;
    }
}
