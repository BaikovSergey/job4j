package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 11.02.19
 */
public class Student implements Comparator<Student> {
    private String name;
    private int score;

    public Student(String name, int scope) {
        this.name = name;
        this.score = scope;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getScore() - (o2.getScore());
    }

    /**
     * Метод возращает список студентов у которых балл аттестата больше bound.
     * @param students Список студентов.
     * @param bound Средний балл.
     * @return Список студентов.
     */
    public List<Student> levelOf(List<Student> students, int bound) {
    return students.stream()
            .sorted(Comparator.comparing(Student::getScore).reversed())
            .flatMap(Stream :: ofNullable)
            .takeWhile(s -> s.getScore() > bound)
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return name
                + '\''
                + score;
    }
}
