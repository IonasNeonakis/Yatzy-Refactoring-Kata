package org.codingdojo.yatzy1;


import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Yatzy1 {

    private final Dice dice;

    public Yatzy1(int dice1, int dice2, int dice3, int dice4, int dice5) {
        this.dice = new Dice(dice1, dice2, dice3, dice4, dice5);
    }


    public int chance() {
        return dice.sum();
    }

    public int yatzy() {
        if (new HashSet<>(dice.values()).size() != 1) {
            return 0;
        }
        return 50;
    }

    public int ones() {
        return sumSameValues(1);
    }

    public int twos() {
        return sumSameValues(2);
    }

    public int threes() {
        return sumSameValues(3);
    }

    public int fours() {
        return sumSameValues(4);

    }

    public int fives() {
        return sumSameValues(5);
    }

    public int sixes() {
        return sumSameValues(6);
    }

    private int sumSameValues(int value) {
        return dice.values().stream().filter(dice -> dice == value).mapToInt(Integer::intValue).sum();
    }

    public int pair() { // TODO refactor
        var highestMatchingDice = dice.values().stream()
            .filter(dice -> this.dice.values().stream().filter(d -> d.equals(dice)).count() >= 2)
            .max(Comparator.naturalOrder())
            .orElse(0);

        return highestMatchingDice * 2;
    }

    public int twoPairs() {
        return dice.values().stream()
            .filter(dice -> this.dice.values().stream().filter(d -> d.equals(dice)).count() >= 2)
            .distinct()
            .mapToInt(Integer::intValue)
            .sum() * 2;
    }

    public int threeOfAKind() {
        return dice.values().stream()
            .filter(dice -> this.dice.values().stream().filter(d -> d.equals(dice)).count() >= 3)
            .findFirst()
            .orElse(0) * 3;
    }

    public int fourOfAKind() {
        return dice.values().stream()
            .filter(dice -> this.dice.values().stream().filter(d -> d.equals(dice)).count() >= 4)
            .findFirst()
            .orElse(0) * 4;
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
        if (threeOfAKind() == 0 || twoPairs() == 0) {
            return 0;
        }
        return dice.sum();
    }
}



