package org.codingdojo.yatzy1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record Dice(List<Integer> values) {

    public Dice {
        verifyLength(values);

        verifyValues(values);
    }

    public Dice(int... values) {
        this(Arrays.stream(values).boxed().toList());
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

    @Override
    public List<Integer> values() {
        return new ArrayList<>(values);
    }

    public int sum() {
        return values.stream().mapToInt(Integer::intValue).sum();
    }
}
