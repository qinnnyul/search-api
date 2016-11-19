package com.thoughtworks.condition;

public class ContainsCondition implements QueryCondition{
    private String container;
    private String queryObject;

    public ContainsCondition(String container, String queryObject) {
        this.container = container;
        this.queryObject = queryObject;
    }

    @Override
    public String generateSql() {
        return container + " @> " + queryObject;
    }
}
