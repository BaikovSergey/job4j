package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Sergey Baikov
 * @version $Id$
 * @since 0.1
 */
public class PointTest {

    /**
     * Test distanceTo.
     */
    @Test
    public void distanceTo() {
    Point a = new Point(0, 0);
    Point b = new Point(2, 0);
    double result = a.distanceTo(b);
    double expected = 2D;
    assertThat(result, closeTo(expected, 0.1D));
    }
}