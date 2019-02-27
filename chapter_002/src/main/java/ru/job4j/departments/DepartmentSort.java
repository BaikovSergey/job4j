package ru.job4j.departments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    public List<String> sort(List<String> list) {
        List<String> result = new ArrayList<>(list);
        result = addDepLvl(result);
        Collections.sort(result);
        return result;
    }

    /**
     * Метод сортирует департамент в порядке убывания с сохранением структуры отделов и добавляет недостающие код верхнеуровнего подразделения.
     * @param list список департаментов
     * @return сортированый список
     */
    public List<String> sortRevers(List<String> list) {
        List<String> result = new ArrayList<>(list);
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
        result = addDepLvl(result);
        result.sort(revers);
        return result;
    }

    /**
     * Метод осуществляет поиск отсутсвующих кодов отделов и добавляет их.
     * @param list список департаментов
     * @return дополненый список
     */
    public List<String> addDepLvl(List<String> list) {
        List<String> result = new ArrayList<>(list);
        for(int i = 0; i < result.size(); i++) {
            String[] buffer = result.get(i).split("/");
            if(buffer.length >= 2) {
                if(!result.contains(buffer[0])) {
                    result.add(buffer[0]);
                }
                if(!result.contains(buffer[0] + "/" + buffer[1])) {
                    result.add(buffer[0] + "/" + buffer[1]);
                }
            }
        }
        return result;
    }
}
