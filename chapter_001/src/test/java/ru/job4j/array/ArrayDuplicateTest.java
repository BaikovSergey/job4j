package ru.job4j.array;


import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Sergey Baikov
 * @version $Id$
 * @since 31.10.18
 */
public class ArrayDuplicateTest {

    /**
     * Test remove.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayTest = new ArrayDuplicate();
        String[] input = {"Hello", "World", "Java", "World", "Hello", "Guild Wars 2", "WoW", "World"};
        String[] result = arrayTest.remove(input);
        String[] expect = {"Hello", "World", "Java", "Guild Wars 2", "WoW"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

    /**
     * Test remove.
     */
    @Test
    public void whenEveryElementIsTheSame() {
        ArrayDuplicate arrayTest = new ArrayDuplicate();
        String[] input = new String[] {"1", "1", "1", "1", "1", "1"};
        String[] result = arrayTest.remove(input);
        String[] expect = new String[] {"1"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

}