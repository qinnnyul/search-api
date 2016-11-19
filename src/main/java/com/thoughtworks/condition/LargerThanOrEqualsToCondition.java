package com.thoughtworks.condition;

public class LargerThanOrEqualsToCondition implements QueryCondition {
    private final String target;
    private final String compareTo;

    public LargerThanOrEqualsToCondition(String target, String compareTo) {
        this.target = target;
        this.compareTo = compareTo;
    }

    @Override
    public String generateSql() {
        return target + " >= " + compareTo;
    }
}
