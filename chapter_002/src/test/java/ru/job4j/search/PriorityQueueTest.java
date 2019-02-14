package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 16.12.18
 */
public class PriorityQueueTest {

    /**
     * Test put.
     */
    @Test
    public void whenHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("last", 8));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
        result = queue.take();
        assertThat(result.getDesc(), is("middle"));
        result = queue.take();
        assertThat(result.getDesc(), is("low"));
        result = queue.take();
        assertThat(result.getDesc(), is("last"));

    }
}