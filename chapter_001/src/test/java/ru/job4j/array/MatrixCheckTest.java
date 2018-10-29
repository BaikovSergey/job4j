package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Sergey Baikov
 * @version $Id$
 * @since 28.10.18
 */
public class MatrixCheckTest {

    /**
     * Test mono.
     */
    @Test
    public void whenMatrix3DataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test mono.
     */
    @Test
    public void whenMatrix3DataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Test mono.
     */
        @Test
        public void whenMatrix4DataMonoByTrueThenTrue() {
            MatrixCheck check = new MatrixCheck();
            boolean[][] input = new boolean[][] {
                    {true, true, true, false},
                    {false, true, false, true},
                    {true, false, true, false},
                    {false, false, true, true}
            };
            boolean result = check.mono(input);
            assertThat(result, is(true));
        }

    /**
     * Test mono.
     */
        @Test
        public void whenMatrix4DataNotMonoByTrueThenFalse() {
            MatrixCheck check = new MatrixCheck();
            boolean[][] input = new boolean[][] {
                    {true, true, true, false},
                    {false, true, true, true},
                    {true, false, true, false},
                    {false, false, true, true}
            };
            boolean result = check.mono(input);
            assertThat(result, is(false));
        }
    }
