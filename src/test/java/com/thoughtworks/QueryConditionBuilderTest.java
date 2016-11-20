package com.thoughtworks;

import com.thoughtworks.builder.QueryConditionBuilder;
import com.thoughtworks.model.QueryParameters;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class QueryConditionBuilderTest {

    public static final String POLICY_NUMBER = "QTE88888";
    public static final String CUSTOMER_NUMBER = "QTE99999";
    public static final String BRAND = "GIO";
    public static final String TYPE = "renewal";
    public static final String PRICE = "10";
    public static final String FROM_DATE = "fromDate";
    public static final String TO_DATE = "toDate";

    @Test
    public void shoudBuildAQueryConditionWhileOnlyPassPolicyNumber() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setPolicyNumber(POLICY_NUMBER);

        QueryConditionBuilder classUnderTest = new QueryConditionBuilder(queryParameters);

        assertThat(classUnderTest.build(), is("body @> {\"policyNumber\":\"QTE88888\"}"));

    }

    @Test
    public void shouldBuildQueryConditionsWhilePassBothPolicyNumberAndCustomerNumber() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setPolicyNumber(POLICY_NUMBER);
        queryParameters.setCustomerNumber(CUSTOMER_NUMBER);

        QueryConditionBuilder classUnderTest = new QueryConditionBuilder(queryParameters);

        assertThat(classUnderTest.build(), is("body @> {\"policyNumber\":\"QTE88888\",\"customerNumber\":\"QTE99999\"}"));

    }

    @Test
    public void shouldGetConditionsWhenPolicyNumberAndCustomerNumberAndBrandExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setPolicyNumber(POLICY_NUMBER);
        queryParameters.setCustomerNumber(CUSTOMER_NUMBER);
        queryParameters.setBrand(BRAND);

        QueryConditionBuilder classUnderTest = new QueryConditionBuilder(queryParameters);

        assertThat(classUnderTest.build(), is("body @> {\"policyNumber\":\"QTE88888\",\"customerNumber\":\"QTE99999\",\"brand\":\"GIO\"}"));

    }

    @Test
    public void shouldGetConditionsWhenPolicyNumberAndCustomerNumberAndBrandAndTypeExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setPolicyNumber(POLICY_NUMBER);
        queryParameters.setCustomerNumber(CUSTOMER_NUMBER);
        queryParameters.setBrand(BRAND);
        queryParameters.setType(TYPE);

        QueryConditionBuilder classUnderTest = new QueryConditionBuilder(queryParameters);

        assertThat(classUnderTest.build().contains(TYPE), is(true));
    }


    @Test
    public void shouldGetRangeConditionWhenOnlyPriceExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setPrice(PRICE);

        QueryConditionBuilder classUnderTest = new QueryConditionBuilder(queryParameters);

        assertThat(classUnderTest.build(), is("body->>price BETWEEN 0 AND 20"));

    }

    @Test
    public void shouldGetRangConditionAndContainsConditionWhenPolicyNumberAndPriceExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setPrice(PRICE);
        queryParameters.setPolicyNumber(POLICY_NUMBER);

        QueryConditionBuilder classUnderTest = new QueryConditionBuilder(queryParameters);

        assertThat(classUnderTest.build(), is("body @> {\"policyNumber\":\"QTE88888\"} AND body->>price BETWEEN 0 AND 20"));

    }

    @Test
    public void shouldGetLargerThanOrEqualsToConditionWhenOnlyFormDateExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setFromDate(FROM_DATE);

        QueryConditionBuilder classUnderTest = new QueryConditionBuilder(queryParameters);

        assertThat(classUnderTest.build(), is("to_date(body->>date, 'YYYY-MM-DD') >= " + FROM_DATE));

    }


    @Test
    public void shouldGetLesshanOrEqualsToConditionWhenOnlyToDateExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setToDate(TO_DATE);

        QueryConditionBuilder classUnderTest = new QueryConditionBuilder(queryParameters);

        assertThat(classUnderTest.build(), is("to_date(body->>date, 'YYYY-MM-DD') <= " + TO_DATE));

    }


    @Test
    public void shouldContainsAndLargerThanAndLessThanAndRangeConditionWhenTheFollowingHappen() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setPolicyNumber(POLICY_NUMBER);
        queryParameters.setPrice(PRICE);
        queryParameters.setFromDate(FROM_DATE);
        queryParameters.setToDate(TO_DATE);

        QueryConditionBuilder classUnderTest = new QueryConditionBuilder(queryParameters);

        assertThat(classUnderTest.build(), is("body @> {\"policyNumber\":\"QTE88888\"} AND " +
                "body->>price BETWEEN 0 AND 20 AND to_date(body->>date, 'YYYY-MM-DD') >= " + FROM_DATE
                + " AND to_date(body->>date, 'YYYY-MM-DD') <= " + TO_DATE));

    }



}