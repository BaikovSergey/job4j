package ru.job4j.departments;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        DepartmentSort test = new DepartmentSort();
        List<String> list = new ArrayList<>();
        list.add("K1/SK1");
        list.add("K2");
        list.add("K1/SK1/SSK1");
        list.add("K2/SK1/SSK1");
        list.add("K1/SK1/SSK2");
        list.add("K2/SK1/SSK2");
        list.add("K1/SK2");
        List<String> expect = Arrays.asList("K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2", "K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2");
        List<String> result = test.sort(list);
        assertThat(result, is(expect));
    }

    /**
     * Test sortRevers.
     */
    @Test
    public void whenSortDescending() {
        DepartmentSort test = new DepartmentSort();
        List<String> list = new ArrayList<>();
        list.add("K1/SK1");
        list.add("K2");
        list.add("K1/SK1/SSK1");
        list.add("K2/SK1/SSK1");
        list.add("K1/SK1/SSK2");
        list.add("K2/SK1/SSK2");
        list.add("K1/SK2");
        List<String> expect = Arrays.asList("K2", "K2/SK1", "K2/SK1/SSK2", "K2/SK1/SSK1", "K1", "K1/SK2", "K1/SK1", "K1/SK1/SSK2", "K1/SK1/SSK1");
        List<String> result = test.sortRevers(list);
        assertThat(result, is(expect));
    }
}
