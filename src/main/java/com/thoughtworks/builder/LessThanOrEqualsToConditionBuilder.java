package com.thoughtworks.builder;

import com.thoughtworks.condition.LessThanOrEqualsToCondition;
import com.thoughtworks.condition.QueryCondition;
import com.thoughtworks.model.QueryParameters;
import org.springframework.util.StringUtils;

import java.util.Optional;

import static org.springframework.util.StringUtils.isEmpty;

public class LessThanOrEqualsToConditionBuilder implements ConditionBuilder {
    private QueryParameters queryParameters;

    public LessThanOrEqualsToConditionBuilder(QueryParameters queryParameters) {
        this.queryParameters = queryParameters;
    }

    @Override
    public boolean match() {
        return !isEmpty(queryParameters.getToDate());
    }

    @Override
    public Optional<QueryCondition> build() {
        return Optional.of(new LessThanOrEqualsToCondition("to_date(body->>date, 'YYYY-MM-DD')", queryParameters.getToDate()));
    }
}
