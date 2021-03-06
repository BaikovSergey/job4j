package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {

    /**
     * Test max.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
    /**
     * Test max.
     */
    @Test
    public void whenFirstBiggerSecond() {
        Max maxim = new Max();
        int result = maxim.max(2, 1);
        assertThat(result, is(2));
    }
    /**
     * Test max.
     */
    @Test
    public void whenFirstEqualSecond() {
        Max maxim = new Max();
        int result = maxim.max(2, 2);
        assertThat(result, is(2));
    }
    /**
     * Test max.
     */
    @Test
    public void whenFirstLessSecondLessThird() {
        Max maxim = new Max();
        int result = maxim.max(1, 2, 3);
        assertThat(result, is(3));
    }
    /**
     * Test max.
     */
    @Test
    public void whenFirstBiggerSecondBiggerThird() {
        Max maxim = new Max();
        int result = maxim.max(3, 2, 1);
        assertThat(result, is(3));
    }
    /**
     * Test max.
     */
    @Test
    public void whenFirstEqualSecondEqualThird() {
        Max maxim = new Max();
        int result = maxim.max(2, 2, 2);
        assertThat(result, is(2));
    }
}
