package ru.job4j.array;

/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 28.10.18
 */
public class FindLoop {

    /**
     * Поиск нужного элемента в заданном массиве перебором.
     * @param data Массив.
     * @param el искомый элемент.
     * @return индекс.
     */
    public int indexOf(int[] data, int el) {
        int result = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                result = index;
                break;
            }
        }
        return result;
    }
}