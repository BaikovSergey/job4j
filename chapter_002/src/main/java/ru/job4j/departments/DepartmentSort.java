package ru.job4j.departments;

import java.util.*;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 26.02.19
 */
public class DepartmentSort {
    /**
     * Метод сортирует департамент в порядке возрастания и добавляет недостающие код верхнеуровнего подразделения.
     * @param list список департаментов
     * @return сортированый список
     */
    public Set<String> sort(Set<String> list) {
        Set<String> result = new TreeSet<>(list);
        result = addDepLvl(result);
        return result;

    }

    /**
     * Метод сортирует департамент в порядке убывания с сохранением структуры отделов и добавляет недостающие код верхнеуровнего подразделения.
     * @param list список департаментов
     * @return сортированый список
     */
    public Set<String> sortRevers(Set<String> list) {
        Comparator<String> revers = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int flag = s2.charAt(1) - s1.charAt(1);
                if (flag == 0) {
                    flag = s1.length() - s2.length();
                    if (flag == 0) {
                        flag = s2.charAt(s2.length() - 1) - s1.charAt(s1.length() - 1);
                    }
                }
                return flag;
            }
        };
        Set<String> result = new TreeSet<>(revers);
        result.addAll(list);
        result.addAll(addDepLvl(result));
        return result;
    }

    /**
     * Метод осуществляет поиск отсутсвующих кодов отделов и добавляет их.
     * @param list список департаментов
     * @return дополненый список
     */
    public Set<String> addDepLvl(Set<String> list) {
        Set<String> result = new HashSet<>(list);
        Org lvls = new Org();
        Set<String> temp = lvls.getDepartmentsLvls();
        result.addAll(temp);
        return result;
    }
}
