package com.thoughtworks.condition;

import com.thoughtworks.condition.LessThanOrEqualsToCondition;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LessThanOrEqualsToConditionTest {

    @Test
    public void shouldReturnSqlForLessThanOrEqualToCondition() throws Exception {
        String target = "body->>price";
        String compareTo = "someValue";
        LessThanOrEqualsToCondition classUnderTest = new LessThanOrEqualsToCondition(target, compareTo);


        assertThat(classUnderTest.generateSql(), is("body->>price <= someValue"));
    }
}