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
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task first = queue.takeFirst();
        Task mid = queue.takeMid();
        Task last = queue.takeLast();
        assertThat(first.getDesc(), is("urgent"));
        assertThat(mid.getDesc(), is("middle"));
        assertThat(last.getDesc(), is("low"));
    }
}