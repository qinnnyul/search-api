package com.thoughtworks.condition;

import com.thoughtworks.condition.LargerThanOrEqualsToCondition;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LargerThanOrEqualsToConditionTest {
    @Test
    public void shouldReturnSqlForLargerThanOrEqualsCondtion() throws Exception {
        String target = "body->>price";
        String compareTo = "someValue";
        LargerThanOrEqualsToCondition classUnderTest = new LargerThanOrEqualsToCondition(target, compareTo);

        assertThat(classUnderTest.generateSql(), is("body->>price >= someValue"));
    }
}