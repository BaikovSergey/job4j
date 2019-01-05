package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {

    @Test
    public void whenListThenTreeSetSortedByAgeAscending() {
        SortUser test = new SortUser();
        User first = new User("Anton", 28);
        User second = new User("Dmitriy", 25);
        User third = new User("Vlad", 24);
        User fourth = new User("Sergei", 25);
        List<User> users = new ArrayList<>();
        users.add(first);
        users.add(second);
        users.add(third);
        users.add(fourth);
        Set<User> result = test.sort(users);
        Set<User> expect = new TreeSet<>();
        expect.add(third);
        expect.add(second);
        expect.add(fourth);
        expect.add(first);
        assertThat(result, is(expect));
    }
}