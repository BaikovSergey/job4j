package ru.job4j.sort;

import java.util.*;

public class SortUser {

    public Set<User> sort (List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength (List<User> list) {
        List<User> result = new ArrayList<>();
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        result.sort(comparator);
        return result;
    }
}
