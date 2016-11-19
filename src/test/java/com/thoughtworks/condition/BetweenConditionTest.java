package com.thoughtworks.condition;

import com.thoughtworks.condition.BetweenCondition;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BetweenConditionTest {

    @Test
    public void shouldReturnSQLforBetweenCondition() throws Exception {
        String target = "to_date(body->>'date', 'YYYY-MM-DD')";
        String from = "fromDate";
        String to = "toDate";
        BetweenCondition classUnderTest = new BetweenCondition(target, from, to);

        String result = classUnderTest.generateSql();

        assertThat(result, is("to_date(body->>'date', 'YYYY-MM-DD') BETWEEN fromDate AND toDate"));
    }
}