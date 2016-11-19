package com.thoughtworks.condition;

public class LessThanOrEqualsToCondition implements QueryCondition{
    private final String target;
    private final String compareTo;

    public LessThanOrEqualsToCondition(String target, String compareTo) {
        this.target = target;
        this.compareTo = compareTo;
    }

    @Override
    public String generateSql() {
        return target + " <= " + compareTo;
    }
}
