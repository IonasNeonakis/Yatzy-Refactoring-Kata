package org.codingdojo.yatzy1;


import java.util.Comparator;
import java.util.List;

public class Yatzy1 {

    public static final int YATZY_SCORE = 50;
    private final Dice dice;

    public Yatzy1(int dice1, int dice2, int dice3, int dice4, int dice5) {
        this.dice = new Dice(dice1, dice2, dice3, dice4, dice5);
    }


    public int chance() {
        return dice.sum();
    }

    public int yatzy() {
        if (dice.values().stream().distinct().count() != 1) {
            return 0;
        }
        return YATZY_SCORE;
    }

    public int ones() {
        return scoreNumber(1);
    }

    public int twos() {
        return scoreNumber(2);
    }

    public int threes() {
        return scoreNumber(3);
    }

    public int fours() {
        return scoreNumber(4);

    }

    public int fives() {
        return scoreNumber(5);
    }

    public int sixes() {
        return scoreNumber(6);
    }

    private int scoreNumber(int value) {
        return dice.values().stream().filter(dice -> dice == value).mapToInt(Integer::intValue).sum();
    }

    public int pair() { // TODO refactor
        var highestMatchingDice = dice.values().stream()
            .filter(dice -> this.dice.values().stream().filter(d -> d.equals(dice)).count() >= 2)
            .max(Comparator.naturalOrder())
            .orElse(0);

        return highestMatchingDice + highestMatchingDice;
    }

    public int twoPairs() {
        var twoMatchingDiceValues =  dice.values().stream()
            .filter(dice -> this.dice.values().stream().filter(d -> d.equals(dice)).count() >= 2)
            .distinct()
            .mapToInt(Integer::intValue)
            .sum();

        return twoMatchingDiceValues * 2;
    }

    public int threeOfAKind() {
        return sumOfIdenticalValues(3);
    }

    public int fourOfAKind() {
        return sumOfIdenticalValues(4);
    }

    private int sumOfIdenticalValues(int x) {
        return dice.values().stream()
            .filter(dice -> this.dice.values().stream().filter(d -> d.equals(dice)).count() >= x)
            .findFirst()
            .orElse(0) * x;
    }


    public int smallStraight() {
        return straightScore(List.of(1, 2, 3, 4, 5));
    }

    public int largeStraight() {
        return straightScore(List.of(2, 3, 4, 5, 6));
    }

    private int straightScore(List<Integer> straight) {
        return dice.values().stream().sorted().toList().equals(straight) ? dice.sum() : 0;
    }

    public int fullHouse() {
        if (threeOfAKind() != 0 && twoPairs() != 0) {
            return dice.sum();
        }
        return 0;
    }
}



