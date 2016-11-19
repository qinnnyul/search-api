package com.thoughtworks.builder;

import com.thoughtworks.condition.QueryCondition;

import java.util.Optional;

public interface ConditionBuilder {
    public boolean match();
    public Optional<QueryCondition> build();
}
