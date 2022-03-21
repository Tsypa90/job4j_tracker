package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FunctionsTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Functions.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = Functions.diapason(1, 4, x -> 2 * Math.pow(x, 2) + 1 * x + 1);
        List<Double> expected = Arrays.asList(4D, 11D, 22D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = Functions.diapason(2, 6, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(4D, 8D, 16D, 32D);
        assertThat(result, is(expected));
    }
}