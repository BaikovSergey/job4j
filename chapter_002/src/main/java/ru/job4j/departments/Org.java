package ru.job4j.departments;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Org implements Comparable {

    List dep = null;

    public Org(List dep) {
        this.dep = dep;
    }


    @Override
    public int compareTo(Object o) {
        return this.dep.size();
    }
}
