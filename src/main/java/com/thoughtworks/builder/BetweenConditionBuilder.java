package com.thoughtworks.builder;

import com.thoughtworks.condition.BetweenCondition;
import com.thoughtworks.condition.QueryCondition;
import com.thoughtworks.model.QueryParameters;
import org.springframework.util.StringUtils;

import java.util.Optional;

import static java.lang.String.valueOf;
import static org.springframework.util.StringUtils.*;

public class BetweenConditionBuilder implements ConditionBuilder{
    private QueryParameters queryParameters;

    public BetweenConditionBuilder(QueryParameters queryParameters) {
        this.queryParameters = queryParameters;
    }

    @Override
    public boolean match() {
        return !isEmpty(queryParameters.getPrice());
    }

    @Override
    public Optional<QueryCondition> build() {
        return Optional.of(new BetweenCondition("body->>price", valueOf(Integer.valueOf(queryParameters.getPrice()) - 10), valueOf(Integer.valueOf(queryParameters.getPrice()) + 10)));
    }
}
