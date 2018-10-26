package ru.job4j.loop;
/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 26.10.18
 */

public class Counter {

    /**
     * Нахождение суммы четных чисел в заданном диапазоне.
     * @param start начальное число в диапазоне.
     * @param finish конечное число в диапазоне.
     * @return сумма.
     */
    public int add(int start, int finish) {
    int sum = 0;
        for (int i = start; i < finish + 1; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
