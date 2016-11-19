package com.thoughtworks.builder;

import com.thoughtworks.model.QueryParameters;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BetweenConditionBuilderTest {

    public static final String PRICE = "10";

    @Test
    public void shouldGetBetweenConditionWhenPriceExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setPrice(PRICE);

        BetweenConditionBuilder classUnderTest = new BetweenConditionBuilder(queryParameters);

        assertThat(classUnderTest.match(), is(true));
    }

    @Test
    public void shouldNotGetBetweenConditionWhenPriceNonExist() throws Exception {
        QueryParameters queryParameters = new QueryParameters();

        BetweenConditionBuilder classUnderTest = new BetweenConditionBuilder(queryParameters);

        assertThat(classUnderTest.match(), is(false));

    }
}