package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 26.10.18
 */

public class CounterTest {

    /**
     * Test add.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
    Counter counter = new Counter();
        int result = counter.add(1, 10);
        assertThat(result, is(30));
    }
}