package ru.job4j.matrix;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 06.02.19
 */
public class MatrixTest {
    /**
     * Test matrixToList.
     */
    @Test
    public void whenMatrixOfIntegerThenListOfInteger() {
        Matrix test = new Matrix();
        Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> expect = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> result = test.matrixToList(matrix);
        assertThat(result, is(expect));
    }

}