package org.codingdojo.yatzy3.strategies;

import org.codingdojo.yatzy3.ScorerStrategy;

import java.util.List;

public class YatzyPointsScorerStrategy implements ScorerStrategy {

    private static final int YATZY_SCORE = 50;

    @Override
    public int calculateScore(List<Integer> dice) {
        if (frequencies(dice).containsValue(5)) {
            return YATZY_SCORE;
        }
        return 0;
    }
}
