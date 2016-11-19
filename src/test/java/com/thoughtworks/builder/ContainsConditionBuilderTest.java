package com.thoughtworks.builder;

import com.thoughtworks.model.QueryParameters;
import org.junit.Test;

import static com.thoughtworks.QueryConditionBuilderTest.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ContainsConditionBuilderTest {

    @Test
    public void shouldGetContainsConditionWhenPolicyNumberExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setPolicyNumber(POLICY_NUMBER);

        ContainsConditionBuilder classUnderTest = new ContainsConditionBuilder(queryParameters);

        assertThat(classUnderTest.match(), is(true));

    }

    @Test
    public void shouldGetContainsConditionWhenCustomerNumberExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setCustomerNumber(CUSTOMER_NUMBER);

        ContainsConditionBuilder classUnderTest = new ContainsConditionBuilder(queryParameters);

        assertThat(classUnderTest.match(), is(true));

    }

    @Test
    public void shouldGetContainsConditionWhenBrandExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setBrand(BRAND);

        ContainsConditionBuilder classUnderTest = new ContainsConditionBuilder(queryParameters);

        assertThat(classUnderTest.match(), is(true));

    }

    @Test
    public void shouldGetContainsConditionWhenTypeExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setType(TYPE);

        ContainsConditionBuilder classUnderTest = new ContainsConditionBuilder(queryParameters);

        assertThat(classUnderTest.match(), is(true));

    }


}