package com.thoughtworks.builder;

import com.thoughtworks.QueryConditionBuilderTest;
import com.thoughtworks.model.QueryParameters;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LessThanOrEqualsToConditionBuilderTest {

    @Test
    public void shouldGetLessThanOrEqualsToCondtionWhenToDateExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setToDate(QueryConditionBuilderTest.TO_DATE);

        LessThanOrEqualsToConditionBuilder classUnderTest = new LessThanOrEqualsToConditionBuilder(queryParameters);
        assertThat(classUnderTest.match(), is(true));
    }

    @Test
    public void shouldNotGetLessThanOrEqualsToCondtionWhenToDateNoneExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();

        LessThanOrEqualsToConditionBuilder classUnderTest = new LessThanOrEqualsToConditionBuilder(queryParameters);
        assertThat(classUnderTest.match(), is(false));
    }
}