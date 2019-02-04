package ru.job4j.student;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 04.02.19
 */
public class School {

    /**
     * Метод фильтрует учеников по их общему среднему баллу.
     * @param students Список студентов.
     * @param predicate Фильтр.
     * @return Список студентов.
     */
   public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
       return students.stream()
               .filter(predicate)
               .collect(Collectors.toList());
   }

    /**
     * Фильтр для высокого балла.
     * @return Predicate
     */
    public static Predicate<Student> highScore() {
        return p -> p.getScore() >= 70;
    }

    /**
     * Фильтр для среднего балла.
     * @return Predicate
     */
    public static Predicate<Student> midScore() {
        return p -> p.getScore() >= 50 && p.getScore() < 70;
    }

    /**
     * Фильтр для низкого балла.
     * @return Predicate
     */
    public static Predicate<Student> lowScore() {
        return p -> p.getScore() < 50;
    }
}
