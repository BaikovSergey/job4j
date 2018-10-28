package ru.job4j.array;

/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 28.10.18
 */
public class Turn {

    /**
     * Поворачивает данный массив.
     * @param array массив.
     * @return массив.
     */
    public int[] back(int[] array) {
        for (int i = 0; i < (array.length / 2); i++) {
            int temp = array [i];
            array [i] = array [array.length - i - 1];
            array [array.length - i - 1] = temp;
        }
        return array;
    }
}