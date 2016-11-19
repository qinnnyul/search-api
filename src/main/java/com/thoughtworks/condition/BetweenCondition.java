package com.thoughtworks.condition;

public class BetweenCondition implements QueryCondition {
    private final String target;
    private final String from;
    private final String to;

    public BetweenCondition(String target, String from, String to) {
        this.target = target;
        this.from = from;
        this.to = to;
    }

    @Override
    public String generateSql() {
        return target + " BETWEEN " + from + " AND " + to;
    }
}
