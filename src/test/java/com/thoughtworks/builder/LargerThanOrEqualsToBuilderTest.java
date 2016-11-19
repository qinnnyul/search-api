package com.thoughtworks.builder;

import com.thoughtworks.QueryConditionBuilderTest;
import com.thoughtworks.model.QueryParameters;
import org.junit.Test;

import static com.thoughtworks.QueryConditionBuilderTest.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LargerThanOrEqualsToBuilderTest {

    @Test
    public void shouldGetLargerThanOrEqualsCondtionWhenFromDateExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setFromDate(FROM_DATE);

        LargerThanOrEqualsToConditionBuilder classUnderTest = new LargerThanOrEqualsToConditionBuilder(queryParameters);
        assertThat(classUnderTest.match(), is(true));

    }

    @Test
    public void shouldNotGetLargerThanOrEqualsCondtionWhenFromDateNoneExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setPolicyNumber(POLICY_NUMBER);

        LargerThanOrEqualsToConditionBuilder classUnderTest = new LargerThanOrEqualsToConditionBuilder(queryParameters);
        assertThat(classUnderTest.match(), is(false));

    }
}