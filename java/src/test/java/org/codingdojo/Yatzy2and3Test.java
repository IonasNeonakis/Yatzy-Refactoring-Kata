package org.codingdojo;

import org.codingdojo.yatzy2.Yatzy2;
import org.codingdojo.yatzy3.Yatzy3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Yatzy2and3Test {

    static Stream<YatzyCalculator> yatzyProvider() {
        return Stream.of(new Yatzy2(), new Yatzy3());
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the chance score, then the sum of all dice is returned")
    public void chanceScoresSumOfAllDice(YatzyCalculator calculator) {
        assertEquals(15, calculator.score(List.of(2, 3, 4, 5, 1), YatzyCategory.CHANCE));
        assertEquals(16, calculator.score(List.of(3, 3, 4, 5, 1), YatzyCategory.CHANCE));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the yatzy score, then 50 is returned if all dice are the same")
    public void yatzyScores50WhenAllDiceAreTheSame(YatzyCalculator calculator) {
        assertEquals(50, calculator.score(List.of(4, 4, 4, 4, 4), YatzyCategory.YATZY));
        assertEquals(50, calculator.score(List.of(6, 6, 6, 6, 6), YatzyCategory.YATZY));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the yatzy score, then 0 is returned if not all dice are the same")
    public void yatzyScores0WhenDiceAreNotAllTheSame(YatzyCalculator calculator) {
        assertEquals(0, calculator.score(List.of(6, 6, 6, 6, 3), YatzyCategory.YATZY));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the ones score, then the sum of all ones is returned")
    public void onesScoresSumOfAllOnes(YatzyCalculator calculator) {
        assertEquals(1, calculator.score(List.of(1, 2, 3, 4, 5), YatzyCategory.ONES));
        assertEquals(2, calculator.score(List.of(1, 2, 1, 4, 5), YatzyCategory.ONES));
        assertEquals(0, calculator.score(List.of(6, 2, 2, 4, 5), YatzyCategory.ONES));
        assertEquals(4, calculator.score(List.of(1, 2, 1, 1, 1), YatzyCategory.ONES));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the twos score, then the sum of all twos is returned")
    public void twosScoresSumOfAllTwos(YatzyCalculator calculator) {
        assertEquals(4, calculator.score(List.of(1, 2, 3, 2, 6), YatzyCategory.TWOS));
        assertEquals(10, calculator.score(List.of(2, 2, 2, 2, 2), YatzyCategory.TWOS));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the threes score, then the sum of all threes is returned")
    public void threesScoresSumOfAllThrees(YatzyCalculator calculator) {
        assertEquals(6, calculator.score(List.of(1, 2, 3, 2, 3), YatzyCategory.THREES));
        assertEquals(12, calculator.score(List.of(2, 3, 3, 3, 3), YatzyCategory.THREES));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the fours score, then the sum of all fours is returned")
    public void foursScoresSumOfAllFours(YatzyCalculator calculator) {
        assertEquals(12, calculator.score(List.of(4, 4, 4, 5, 5), YatzyCategory.FOURS));
        assertEquals(8, calculator.score(List.of(4, 4, 5, 5, 5), YatzyCategory.FOURS));
        assertEquals(4, calculator.score(List.of(4, 5, 5, 5, 5), YatzyCategory.FOURS));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the fives score, then the sum of all fives is returned")
    public void fivesScoresSumOfAllFives(YatzyCalculator calculator) {
        assertEquals(10, calculator.score(List.of(4, 4, 4, 5, 5), YatzyCategory.FIVES));
        assertEquals(15, calculator.score(List.of(4, 4, 5, 5, 5), YatzyCategory.FIVES));
        assertEquals(20, calculator.score(List.of(4, 5, 5, 5, 5), YatzyCategory.FIVES));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the sixes score, then the sum of all sixes is returned")
    public void sixesScoresSumOfAllSixes(YatzyCalculator calculator) {
        assertEquals(0, calculator.score(List.of(4, 4, 4, 5, 5), YatzyCategory.SIXES));
        assertEquals(6, calculator.score(List.of(4, 4, 6, 5, 5), YatzyCategory.SIXES));
        assertEquals(18, calculator.score(List.of(6, 5, 6, 6, 5), YatzyCategory.SIXES));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the pair score, then the sum of the highest pair is returned")
    public void pairScoresHighestPair(YatzyCalculator calculator) {
        assertEquals(6, calculator.score(List.of(3, 4, 3, 5, 6), YatzyCategory.PAIR));
        assertEquals(10, calculator.score(List.of(5, 3, 3, 3, 5), YatzyCategory.PAIR));
        assertEquals(12, calculator.score(List.of(5, 3, 6, 6, 5), YatzyCategory.PAIR));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the two pairs score, then the sum of the two highest pairs is returned")
    public void twoPairsScoresSumOfTwoHighestPairs(YatzyCalculator calculator) {
        assertEquals(16, calculator.score(List.of(3, 3, 5, 4, 5), YatzyCategory.TWO_PAIRS));
        assertEquals(16, calculator.score(List.of(3, 3, 5, 5, 5), YatzyCategory.TWO_PAIRS));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the three of a kind score, then the sum of the three matching dice is returned")
    public void threeOfAKindScoresSumOfThreeMatchingDice(YatzyCalculator calculator) {
        assertEquals(9, calculator.score(List.of(3, 3, 3, 4, 5), YatzyCategory.THREE_OF_A_KIND));
        assertEquals(15, calculator.score(List.of(5, 3, 5, 4, 5), YatzyCategory.THREE_OF_A_KIND));
        assertEquals(9, calculator.score(List.of(3, 3, 3, 3, 5), YatzyCategory.THREE_OF_A_KIND));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the four of a kind score, then the sum of the four matching dice is returned")
    public void fourOfAKindScoresSumOfFourMatchingDice(YatzyCalculator calculator) {
        assertEquals(12, calculator.score(List.of(3, 3, 3, 3, 5), YatzyCategory.FOUR_OF_A_KIND));
        assertEquals(20, calculator.score(List.of(5, 5, 5, 4, 5), YatzyCategory.FOUR_OF_A_KIND));
        assertEquals(12, calculator.score(List.of(3, 3, 3, 3, 3), YatzyCategory.FOUR_OF_A_KIND));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the small straight score, then 15 is returned if the dice form a sequence from 1 to 5")
    public void smallStraightScores15IfDiceFormSequence1To5(YatzyCalculator calculator) {
        assertEquals(15, calculator.score(List.of(1, 2, 3, 4, 5), YatzyCategory.SMALL_STRAIGHT));
        assertEquals(15, calculator.score(List.of(2, 3, 4, 5, 1), YatzyCategory.SMALL_STRAIGHT));
        assertEquals(0, calculator.score(List.of(1, 2, 2, 4, 5), YatzyCategory.SMALL_STRAIGHT));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the large straight score, then 20 is returned if the dice form a sequence from 2 to 6")
    public void largeStraightScores20IfDiceFormSequence2To6(YatzyCalculator calculator) {
        assertEquals(20, calculator.score(List.of(6, 2, 3, 4, 5), YatzyCategory.LARGE_STRAIGHT));
        assertEquals(20, calculator.score(List.of(2, 3, 4, 5, 6), YatzyCategory.LARGE_STRAIGHT));
        assertEquals(0, calculator.score(List.of(1, 2, 2, 4, 5), YatzyCategory.LARGE_STRAIGHT));
    }

    @ParameterizedTest
    @MethodSource("yatzyProvider")
    @DisplayName("Given a dice roll, when calculating the full house score, then the sum of all dice is returned if the roll is a full house")
    public void fullHouseScoresSumOfAllDiceIfRollIsFullHouse(YatzyCalculator calculator) {
        assertEquals(18, calculator.score(List.of(6, 2, 2, 2, 6), YatzyCategory.FULL_HOUSE));
        assertEquals(0, calculator.score(List.of(2, 3, 4, 5, 6), YatzyCategory.FULL_HOUSE));
    }
}