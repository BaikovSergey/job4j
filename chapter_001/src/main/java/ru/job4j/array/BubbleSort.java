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
        boolean needToSort = false;
        if (needToSort) {
            return  array;
        } else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - 1; j++) {
                    if (array [j] > array [j + 1]) {
                        int temp = array [j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        needToSort = true;
                    }
                }
            }
            return array;
        }
    }
}