package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 07.11.18
 */
public class ArrayAdd {

    /**
     * Формирует новый сортированный массив из двух данных.
     *
     * @param first  первый массив.
     * @param second второй массив.
     * @return массив.
     */
    public int[] add(int[] first, int[] second) {
            int indexI = 0;
            int indexJ = 0;
            int indexK = 0;
            int[] array = new int[first.length + second.length];
            for (int i = 0, j = 0, k = 0; i < first.length & j < second.length & k <= array.length;) {
                if (first[i] < second[j]) {
                    array[k] = first[i];
                    i++;
                    k++;
                    indexK++;
                    indexI++;
                } else {
                    array[k] = second[j];
                    j++;
                    k++;
                    indexK++;
                    indexJ++;
                }
            }
            if (indexI != first.length) {
                for (int c = indexI; c < first.length; c++) {
                    array[indexK] = first[c];
                    indexK++;
                }
            } else {
                for (int d = indexJ; d < second.length; d++) {
                    array[indexK] = second[d];
                    indexK++;
                }
            }
        return array;
    }
}
