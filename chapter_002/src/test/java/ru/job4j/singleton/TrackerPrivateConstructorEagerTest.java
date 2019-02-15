package ru.job4j.singleton;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 14.02.19
 */
public class TrackerPrivateConstructorEagerTest {

    /**
     * Test singleton.
     */
    @Test
    public void thenCreateInstanceWhenOnlyOneInstance() {
        TrackerPrivateConstructorEager first = TrackerPrivateConstructorEager.getInstance();
        TrackerPrivateConstructorEager second = TrackerPrivateConstructorEager.getInstance();
        assertThat(first, is (second));
    }

}