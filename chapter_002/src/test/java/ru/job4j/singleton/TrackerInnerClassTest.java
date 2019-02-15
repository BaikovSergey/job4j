package ru.job4j.singleton;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 14.02.19
 */
public class TrackerInnerClassTest {

    /**
     * Test singleton.
     */
    @Test
    public void thenCreateInstanceWhenOnlyOneInstance() {
        TrackerInnerClass first = TrackerInnerClass.getInstance();
        TrackerInnerClass second = TrackerInnerClass.getInstance();
        assertThat(first, is(second));
    }

}