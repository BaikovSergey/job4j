package ru.job4j.lambda;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 24.01.19
 */
public class DiapasonTest {

    /**
     * Test linear function.
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    /**
     * Test quadratic function function.
     */
    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    /**
     * Test quadratic function function.
     */
    @Test
    public void whenLogarithmFunctionThenLogarithmResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(1, 3, x -> Math.log(x) / Math.log(2) + 1);
        List<Double> expected = Arrays.asList(1D, 2D);
        assertThat(result, is(expected));
    }
}