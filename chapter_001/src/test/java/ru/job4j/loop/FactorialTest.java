package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 26.10.18
 */

public class FactorialTest {

    /**
     * Test calc.
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial fac = new Factorial();
        int result = fac.calc(5);
        assertThat(result, is(120));
    }

    /**
     * Test calc.
     */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial fac = new Factorial();
        int result = fac.calc(0);
        assertThat(result, is(1));
    }
}