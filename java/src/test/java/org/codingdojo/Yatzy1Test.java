package org.codingdojo;

import org.codingdojo.yatzy1.Yatzy1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Yatzy1Test {

    @Test
    @DisplayName("given a dice roll, when calculating the chance, then the sum of all dice is returned")
    public void chance() {
        var yatzy = new Yatzy1(2,3,4,5,1);
        var expected = 15;
        var actual = yatzy.chance();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("given a dice roll, when calculating the yatzy, then 50 is returned if all dice are the same")
    public void yatzy() {
        var actual = new Yatzy1(4,4,4,4,4).yatzy();
        int expected = 50;

        assertEquals(expected, actual);
        assertEquals(0, new Yatzy1(6,6,6,6,3).yatzy());
    }

    @DisplayName("given a dice roll, when calculating the ones, then the sum of all ones is returned")
    @Test
    public void ones() {
        assertEquals(1, new Yatzy1(1, 2, 3, 4, 5).ones());
        assertEquals(2, new Yatzy1(1,2,1,4,5).ones());
        assertEquals(0, new Yatzy1(6,2,2,4,5).ones());
        assertEquals(4, new Yatzy1(1,2,1,1,1).ones());
    }

    @Test
    @DisplayName("given a dice roll, when calculating the twos, then the sum of all twos is returned")
    public void twos() {
        assertEquals(4, new Yatzy1(1,2,3,2,6).twos());
        assertEquals(10, new Yatzy1(2,2,2,2,2).twos());
    }

    @Test
    @DisplayName("given a dice roll, when calculating the threes, then the sum of all threes is returned")
    public void threes() {
        assertEquals(6, new Yatzy1(1,2,3,2,3).threes());
        assertEquals(12, new Yatzy1(2,3,3,3,3).threes());
    }

    @Test
    @DisplayName("given a dice roll, when calculating the fours, then the sum of all fours is returned")
    public void fours()
    {
        assertEquals(12, new Yatzy1(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy1(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy1(4,5,5,5,5).fours());
    }

    @Test
    @DisplayName("given a dice roll, when calculating the fives, then the sum of all fives is returned")
    public void fives() {
        assertEquals(10, new Yatzy1(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy1(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy1(4,5,5,5,5).fives());
    }

    @Test
    @DisplayName("given a dice roll, when calculating the sixes, then the sum of all sixes is returned")
    public void sixes() {
        assertEquals(0, new Yatzy1(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy1(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy1(6,5,6,6,5).sixes());
    }

    @Test
    @DisplayName("given a dice roll, when calculating the pair, then the sum of the highest pair is returned")
    public void pair() {
        assertEquals(6, new Yatzy1(3,4,3,5,6).pair());
        assertEquals(10, new Yatzy1(5,3,3,3,5).pair());
        assertEquals(12, new Yatzy1(5,3,6,6,5).pair());
    }

    @Test
    @DisplayName("given a dice roll, when calculating the two pairs, then the sum of the two pairs is returned")
    public void twoPairs() {
        assertEquals(16, new Yatzy1(3,3,5,4,5).twoPairs());
        assertEquals(16, new Yatzy1(3,3,5,5,5).twoPairs());
    }

    @Test
    @DisplayName("given a dice roll, when calculating the three of a kind, then the sum of the three of a kind is returned")
    public void threeOfAKind()
    {
        assertEquals(9, new Yatzy1(3,3,3,4,5).threeOfAKind());
        assertEquals(15, new Yatzy1(5,3,5,4,5).threeOfAKind());
        assertEquals(9, new Yatzy1(3,3,3,3,5).threeOfAKind());
    }

    @Test
    @DisplayName("given a dice roll, when calculating the four of a kind, then the sum of the four of a kind is returned")
    public void fourOfAKnd() {
        assertEquals(12, new Yatzy1(3,3,3,3,5).fourOfAKind());
        assertEquals(20, new Yatzy1(5,5,5,4,5).fourOfAKind());
    }

    @Test
    @DisplayName("given a dice roll, when calculating the small straight, then 15 is returned if the dice are 1,2,3,4,5")
    public void smallStraight() {
        assertEquals(15, new Yatzy1(1,2,3,4,5).smallStraight());
        assertEquals(15, new Yatzy1(2,3,4,5,1).smallStraight());
        assertEquals(0, new Yatzy1(1,2,2,4,5).smallStraight());
    }

    @Test
    @DisplayName("given a dice roll, when calculating the large straight, then 20 is returned if the dice are 2,3,4,5,6")
    public void largeStraight() {
        assertEquals(20,new Yatzy1(6,2,3,4,5).largeStraight());
        assertEquals(20,new Yatzy1(2,3,4,5,6).largeStraight());
        assertEquals(0,new Yatzy1(1,2,2,4,5).largeStraight());
    }

    @Test
    @DisplayName("given a dice roll, when calculating the full house, then the sum of the full house is returned")
    public void fullHouse() {
        assertEquals(18, new Yatzy1(6,2,2,2,6).fullHouse());
        assertEquals(0, new Yatzy1(2,3,4,5,6).fullHouse());
    }
}
