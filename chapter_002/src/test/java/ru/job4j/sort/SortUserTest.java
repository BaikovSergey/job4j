package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 09.01.19
 */
public class SortUserTest {

    /**
     * Test sort
     */
    @Test
    public void whenListThenTreeSetSortedByAgeAscending() {
        SortUser test = new SortUser();
        User first = new User("Anton", 28);
        User second = new User("Dmitriy", 25);
        User third = new User("Vlad", 24);
        User fourth = new User("Sergei", 25);
        List<User> users = List.of(
                first,
                second,
                third,
                fourth);
        Set<User> result = test.sort(users);
        Set<User> expect = Set.of(
                third,
                second,
                first);
        System.out.println(users);
        System.out.println(result);
        assertThat(result, is(expect));
    }

    /**
     * Test sortNameLength
     */
    @Test
    public void whenListThenListSortedByNameLength() {
        SortUser test = new SortUser();
        User first = new User("Bob", 28);
        User second = new User("Dmitriy", 25);
        User third = new User("Vlad", 24);
        User fourth = new User("Sergei", 25);
        List<User> users = List.of(
                first,
                second,
                third,
                fourth);
        List<User> result = test.sortNameLength(users);
        List<User> expect = List.of(
                first,
                third,
                fourth,
                second);
        assertThat(result, is(expect));
    }

    /**
     * Test sortByAllFields
     */
    @Test
    public void whenListThenListSortedByNameThenByAge() {
        SortUser test = new SortUser();
        User first = new User("Bob", 28);
        User second = new User("Dmitriy", 25);
        User third = new User("Bob", 24);
        User fourth = new User("Sergei", 25);
        List<User> users = List.of(
                first,
                second,
                third,
                fourth);

        List<User> result = test.sortByAllFields(users);
        List<User> expect = List.of(
                third,
                first,
                second,
                fourth);
        System.out.println(result);
        assertThat(result, is(expect));
    }
}