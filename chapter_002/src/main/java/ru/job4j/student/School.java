package ru.job4j.student;

import java.util.List;
import java.util.Map;
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
     * Метод преобразует сисок в таблицу.
     * @param students Список студентов.
     * @return Таблица студентов.
     */
    public Map<String, StudentToMap> collectMap(List<StudentToMap> students) {
        return students.stream()
                .collect(Collectors.toMap(StudentToMap::getSurname, s -> s));
    }
}
