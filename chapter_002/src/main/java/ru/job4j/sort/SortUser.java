package ru.job4j.sort;

import java.util.*;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 09.01.19
 */
public class SortUser {

    /**
     * Метод сортирует пользователей по возрасту в порядке возрастания
     * @param list список пользователей
     * @return TreeSet
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    /**
     * Метод сортирует пользователей длине имени
     * @param list список пользователей
     * @return список
     */
    public List<User> sortNameLength(List<User> list) {
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

    /**
     * Метод сортирует пользователей, сначала по имени в лексикографическом порядке, потом по возрасту
     * @param list список пользователей
     * @return спислк
     */
    public List<User> sortByAllFields(List<User> list) {
        List<User> result = new ArrayList<>();
        Comparator<User> nameAndAgeComparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int flag = o1.getAge() - o2.getAge();
                if (flag == 0) {
                    flag = o1.getName().compareTo(o2.getName());
                }
                return flag;
            }
        };
        result.sort(nameAndAgeComparator);
        return result;
    }
}
