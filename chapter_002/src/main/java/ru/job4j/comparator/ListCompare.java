package ru.job4j.comparator;

import java.util.Comparator;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 09.01.19
 */
public class ListCompare implements Comparator<String> {

    /**
     * Компаратор для сравнения двух массивов символов.
     *
     * @param left  первая строка
     * @param right вторая строка
     * @return 0, если строки одинаковые. 1, если первая строка длинее второй или буква в первом слове больше чем во втором.
     * -1, если первая строка короче второй или буква в первом слове меньше чем во втором.
     */
    @Override
    public int compare(String left, String right) {
        int result = Integer.compare(left.length(), right.length());
        int lenght = Math.min(left.length(), right.length());
        for (int i = 0; i < lenght; i++) {
            int a = Character.compare(left.charAt(i), right.charAt(i));
            if (a != 0) {
                result = a;
                break;
            }
        }
        return result;
    }
}