package ru.job4j.pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 23.11.18
 */
public class TriangleTest {

    /**
     * Test triangle.
     */
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("   +")
                                .append("\n  +++")
                                .append("\n +++++")
                                .append("\n+++++++")
                                .toString()
                )
        );
    }
}