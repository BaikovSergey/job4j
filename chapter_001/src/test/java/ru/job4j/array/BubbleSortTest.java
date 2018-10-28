package ru.job4j.array;

import org.hamcrest.Matchers;
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
public class BubbleSortTest {

    /**
     * Test sort.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int[] input = new int[] {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result = bubble.sort(input);
        int[] expect = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, Matchers.is(expect));
    }

    /**
     * Test sort.
     */
    @Test
    public void whenSortArrayWithTwoElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int[] input = new int[] {3, 1};
        int[] result = bubble.sort(input);
        int[] expect = new int[] {1, 3};
        assertThat(result, Matchers.is(expect));
    }
}