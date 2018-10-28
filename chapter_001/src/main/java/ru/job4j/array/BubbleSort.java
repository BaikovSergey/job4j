package ru.job4j.array;

/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 28.10.18
 */
public class BubbleSort {

    /**
     * Сортириует массив методом перестановки.
     * @param array массив.
     * @return массив.
     */
    public int[] sort(int[] array) {
        // внешний цикл определяет кол-во проходов по данному массиву.
    for (int i = 0; i < array.length; i++) {
        // внутренний цикл перестовляет элементы.
        for (int j = 0; j < array.length - 1; j++) {
                if (array [j] > array [j + 1]) {
                int temp = array [j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
    return array;
    }
}
