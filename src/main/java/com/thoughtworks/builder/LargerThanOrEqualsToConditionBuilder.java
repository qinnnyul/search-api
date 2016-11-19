package com.thoughtworks.builder;

import com.thoughtworks.condition.LargerThanOrEqualsToCondition;
import com.thoughtworks.condition.QueryCondition;
import com.thoughtworks.model.QueryParameters;
import org.springframework.util.StringUtils;

import java.util.Optional;

import static org.springframework.util.StringUtils.isEmpty;

public class LargerThanOrEqualsToConditionBuilder implements ConditionBuilder {
    private QueryParameters queryParameters;

    public LargerThanOrEqualsToConditionBuilder(QueryParameters queryParameters) {
        this.queryParameters = queryParameters;
    }

    @Override
    public boolean match() {
        return !isEmpty(queryParameters.getFromDate());
    }

    @Override
    public Optional<QueryCondition> build() {
        return Optional.of(new LargerThanOrEqualsToCondition("to_date(body->>date, 'YYYY-MM-DD')", queryParameters.getFromDate()));
    }
}
