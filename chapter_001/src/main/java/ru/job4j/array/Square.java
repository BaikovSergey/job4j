package ru.job4j.array;

/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 28.10.18
 */
public class Square {

    /**
     * Заполнение массива от 1 до bound и возведение их в квадрат.
     * @param bound Рост.
     * @return массив.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int i = 0; i < bound; i++) {
            rst [i] = (int) Math.pow(i + 1, 2);
        }
        return rst;
    }
}