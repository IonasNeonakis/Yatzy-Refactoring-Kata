package org.codingdojo.yatzy2;

import org.codingdojo.StraightType;
import org.codingdojo.YatzyCalculator;
import org.codingdojo.YatzyCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Yatzy2 implements YatzyCalculator {
    private static final List<Integer> DICE_VALUES = List.of(6, 5, 4, 3, 2, 1);
    public static final int YATZY_SCORE = 50;

    private final Map<Integer, Integer> diceFrequencies = new HashMap<>();

    private void initialiseDiceFrequencies(List<Integer> dice) {
        DICE_VALUES.forEach(die -> diceFrequencies.put(die, 0));

        dice.forEach(die -> diceFrequencies.put(die, diceFrequencies.getOrDefault(die, 0) + 1));
    }

    @Override
    public int score(List<Integer> dice, YatzyCategory category) {
        validateDice(dice);
        initialiseDiceFrequencies(dice);

        return switch (category) {
            case CHANCE -> getSum(dice);
            case YATZY -> calculateYatzy();

            case ONES -> scoreNumber(1);
            case TWOS -> scoreNumber(2);
            case THREES -> scoreNumber(3);
            case FOURS -> scoreNumber(4);
            case FIVES -> scoreNumber(5);
            case SIXES -> scoreNumber(6);

            case PAIR -> calculateScoreForKind(2);
            case THREE_OF_A_KIND -> calculateScoreForKind(3);
            case FOUR_OF_A_KIND -> calculateScoreForKind(4);

            case SMALL_STRAIGHT -> calculateStraight(dice, StraightType.SMALL);
            case LARGE_STRAIGHT -> calculateStraight(dice, StraightType.LARGE);

            case TWO_PAIRS -> calculateTwoPairs();

            case FULL_HOUSE -> calculateFullHouse(dice);
        };
    }

    private int calculateYatzy() {
        return diceFrequencies.containsValue(5) ? YATZY_SCORE : 0;
    }

    private void validateDice(List<Integer> dice) {
        verifyValues(dice);
        verifyLength(dice);
    }

    private void verifyValues(List<Integer> values) {
        values.forEach((value) -> {
            if (value < 1 || value > 6) {
                throw new IllegalArgumentException("Dice values must be between 1 and 6");
            }
        });
    }

    private void verifyLength(List<Integer> values) {
        if (values.size() != 5) {
            throw new IllegalArgumentException("There must be 5 dice");
        }
    }

    private int calculateFullHouse(List<Integer> dice) {
        if (!diceFrequencies.containsValue(2) || !diceFrequencies.containsValue(3)) {
            return 0;
        }
        return getSum(dice);
    }

    private int calculateTwoPairs() {
        if (getNumberOfPairs() != 2) {
            return 0;
        }
        return DICE_VALUES.stream().mapToInt(Integer::intValue).filter(die -> diceFrequencies.get(die) >= 2).sum() * 2;
    }

    private long getNumberOfPairs() {
        return diceFrequencies.values().stream().filter(frequency -> frequency >= 2).count();
    }

    private int scoreNumber(int value) {
        return diceFrequencies.get(value) * value;
    }

    private int calculateStraight(List<Integer> dice, StraightType straightType) {
        if (getNumberOfUniqueValues() != 5 || diceFrequencies.get(straightType.getMissingDiceValue()) != 0) {
            return 0;
        }

        return getSum(dice);
    }

    private static int getSum(List<Integer> dice) {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }

    private long getNumberOfUniqueValues() {
        return diceFrequencies.values().stream().filter(frequency -> frequency == 1).count();
    }

    private int calculateScoreForKind(int kind) {
        return DICE_VALUES.stream()
            .filter(die -> diceFrequencies.getOrDefault(die, 0) >= kind)
            .mapToInt(die -> die * kind)
            .findFirst()
            .orElse(0);
    }
}

