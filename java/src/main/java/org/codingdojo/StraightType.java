package org.codingdojo;

public enum StraightType {
    SMALL(6),
    LARGE(1);

    private final int missingDiceValue;

    StraightType(int missingDiceValue) {
        this.missingDiceValue = missingDiceValue;
    }

    public int getMissingDiceValue() {
        return missingDiceValue;
    }
}
