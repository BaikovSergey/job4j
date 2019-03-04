package ru.job4j.departments;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Org {

    private Set<String> departmentsLvls = new TreeSet<>(
            List.of("K1",
                    "K1/SK1",
                    "K1/SK1/SSK1",
                    "K1/SK1/SSK2",
                    "K1/SK2",
                    "K2",
                    "K2/SK1",
                    "K2/SK1/SSK1",
                    "K2/SK1/SSK2")
    );

    public Set<String> getDepartmentsLvls() {
        return this.departmentsLvls;
    }
}
