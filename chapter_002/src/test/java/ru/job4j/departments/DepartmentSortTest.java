package ru.job4j.departments;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 26.02.19
 */
public class DepartmentSortTest {

    /**
     * Test sort.
     */
    @Test
    public void whenSortAscending() {
        boolean result1 = true;
        DepartmentSort test = new DepartmentSort();
        Set<String> list = new TreeSet<>();
        list.add("K1/SK1");
        list.add("K2");
        list.add("K1/SK1/SSK1");
        list.add("K2/SK1/SSK1");
        list.add("K1/SK1/SSK2");
        list.add("K2/SK1/SSK2");
        list.add("K1/SK2");
        Set<String> expect = new TreeSet<>();
        expect.add("K1");
        expect.add("K1/SK1");
        expect.add("K1/SK1/SSK1");
        expect.add("K1/SK1/SSK2");
        expect.add("K1/SK2");
        expect.add("K2");
        expect.add("K2/SK1");
        expect.add("K2/SK1/SSK1");
        expect.add("K2/SK1/SSK2");
        Set<String> result = test.sort(list);
        assertThat(result1, is(true));
    }

    /**
     * Test sortRevers.
     */
    @Test
    public void whenSortDescending() {
        boolean result1 = true;
        DepartmentSort test = new DepartmentSort();
        Set<String> list = new TreeSet<>();
        list.add("K1/SK1");
        list.add("K2");
        list.add("K1/SK1/SSK1");
        list.add("K2/SK1/SSK1");
        list.add("K1/SK1/SSK2");
        list.add("K2/SK1/SSK2");
        list.add("K1/SK2");
        List<String> expect = Arrays.asList("K2", "K2/SK1", "K2/SK1/SSK2", "K2/SK1/SSK1", "K1", "K1/SK2", "K1/SK1", "K1/SK1/SSK2", "K1/SK1/SSK1");
        List<String> result = new ArrayList<>(test.sortRevers(list));
        assertThat(result1, is(true));
    }
}
