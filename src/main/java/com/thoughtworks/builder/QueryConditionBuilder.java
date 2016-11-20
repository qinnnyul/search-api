package com.thoughtworks.builder;

import com.thoughtworks.model.QueryParameters;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.join;
import static java.util.Arrays.asList;

public class QueryConditionBuilder {

    private final QueryParameters queryParameters;

    public QueryConditionBuilder(QueryParameters queryParameters) {
        this.queryParameters = queryParameters;
    }

    public String build() {
        List<ConditionBuilder> builders = asList(new ContainsConditionBuilder(queryParameters),
                new BetweenConditionBuilder(queryParameters),
                new LargerThanOrEqualsToConditionBuilder(queryParameters),
                new LessThanOrEqualsToConditionBuilder(queryParameters));

        List<String> conditionSqls = builders.stream().filter(conditionBuilder -> conditionBuilder.match())
                .map(conditionBuilder -> conditionBuilder.build().get().generateSql())
                .collect(Collectors.toList());

        return join(" AND ", conditionSqls);
    }

}
