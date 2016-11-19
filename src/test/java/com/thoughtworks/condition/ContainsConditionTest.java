package com.thoughtworks.condition;

import com.thoughtworks.condition.ContainsCondition;
import org.json.JSONObject;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ContainsConditionTest {

    @Test
    public void shouldReturnSqlForContainsCondition() throws Exception {
        String container = "body";

        JSONObject queryObject = new JSONObject();
        queryObject.put("policyNumber", "QTE2342343");
        queryObject.put("customerNumber", "QTE234343l");

        ContainsCondition containsCondition = new ContainsCondition(container, queryObject.toString());

        assertThat(containsCondition.generateSql(), is("body @> {\"policyNumber\":\"QTE2342343\",\"customerNumber\":\"QTE234343l\"}"));

    }
}