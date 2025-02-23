package org.codingdojo.yatzy3;

import org.codingdojo.StraightType;
import org.codingdojo.YatzyCategory;
import org.codingdojo.yatzy3.strategies.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface ScorerStrategy {
    List<Integer> DICE_VALUES = Arrays.asList(6, 5, 4, 3, 2, 1);

    int calculateScore(List<Integer> dice);

    static ScorerStrategy getStrategy(YatzyCategory category) {
        return switch (category) {
            case CHANCE -> new ChanceScorerStrategy();
            case YATZY -> new YatzyPointsScorerStrategy();
            case ONES -> new NumberScorerStrategy(1);
            case TWOS -> new NumberScorerStrategy(2);
            case THREES -> new NumberScorerStrategy(3);
            case FOURS -> new NumberScorerStrategy(4);
            case FIVES -> new NumberScorerStrategy(5);
            case SIXES -> new NumberScorerStrategy(6);
            case PAIR -> new RepeatedCountScorerStrategy(2);
            case THREE_OF_A_KIND -> new RepeatedCountScorerStrategy(3);
            case FOUR_OF_A_KIND -> new RepeatedCountScorerStrategy(4);
            case SMALL_STRAIGHT -> new StraightScorerStrategy(StraightType.SMALL);
            case LARGE_STRAIGHT -> new StraightScorerStrategy(StraightType.LARGE);
            case TWO_PAIRS -> new TwoPairsScorerStrategy();
            case FULL_HOUSE -> new FullHouseScorerStrategy();
        };
    }

    default Map<Integer, Integer> frequencies(List<Integer> dice) {
        return DICE_VALUES.stream()
            .collect(Collectors.toMap(
                i -> i,
                i -> Collections.frequency(dice, i)
            ));
    }


    default int sum(List<Integer> dice) {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }
}
