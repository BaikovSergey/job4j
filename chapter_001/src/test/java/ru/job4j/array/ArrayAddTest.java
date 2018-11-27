package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Sergey Baikov
 * @version $Id$
 * @since 07.11.18
 */
public class ArrayAddTest {

    /**
     * Test add.
     */
    @Test
    public void nameSomeHow() {
        ArrayAdd array = new ArrayAdd();
        int[] inputOne = {2, 4, 5};
        int[] inputTwo = {1, 3, 6};
        int[] result = array.add(inputOne, inputTwo);
        int[] expect = new int[]{1, 2, 3, 4, 5, 6};
        assertThat(result, Matchers.is(expect));
    }

    /**
     * Test add.
     */
    @Test
    public void nameSomeHowTwo() {
        ArrayAdd array = new ArrayAdd();
        int[] inputOne = {45, 50, 70};
        int[] inputTwo = {1, 3, 6};
        int[] result = array.add(inputOne, inputTwo);
        int[] expect = new int[]{1, 3, 6, 45, 50, 70};
        assertThat(result, Matchers.is(expect));
    }
    /**
     * Test add.
     */
    @Test
    public void nameSomeHowThree() {
        ArrayAdd array = new ArrayAdd();
        int[] inputOne = {2, 25};
        int[] inputTwo = {1, 3, 5};
        int[] result = array.add(inputOne, inputTwo);
        int[] expect = new int[]{1, 2, 3, 5, 25};
        assertThat(result, Matchers.is(expect));
    }
}