package com.thoughtworks.builder;

import com.thoughtworks.condition.ContainsCondition;
import com.thoughtworks.condition.QueryCondition;
import com.thoughtworks.model.QueryParameters;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.util.StringUtils.isEmpty;

public class ContainsConditionBuilder implements ConditionBuilder {

    private QueryParameters queryParameters;

    public ContainsConditionBuilder(QueryParameters queryParameters) {
        this.queryParameters = queryParameters;
    }

    @Override
    public boolean match() {
        return !isEmpty(queryParameters.getPolicyNumber()) ||
                !isEmpty(queryParameters.getCustomerNumber()) ||
                !isEmpty(queryParameters.getType()) ||
                !isEmpty(queryParameters.getBrand());
    }

    @Override
    public Optional<QueryCondition> build() {
        Map<String, String> queryMap = new LinkedHashMap<>();
        if (!isEmpty(queryParameters.getPolicyNumber())) {
            queryMap.put("policyNumber", queryParameters.getPolicyNumber());
        }

        if (!isEmpty(queryParameters.getCustomerNumber())) {
            queryMap.put("customerNumber", queryParameters.getCustomerNumber());
        }

        if (!isEmpty(queryParameters.getBrand())) {
            queryMap.put("brand", queryParameters.getBrand());
        }

        if (!isEmpty(queryParameters.getType())) {
            queryMap.put("type", queryParameters.getType());
        }
        return Optional.of(new ContainsCondition("body", new JSONObject(queryMap).toString()));
    }
}
