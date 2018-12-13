package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 13.12.18
 */
public class ConvertMatrix2List {

    /**
     * Метод конвертирует список в двумерный массив
     * @param array двумерный массив
     * @return список
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] anArray : array) {
            for (int i = 0; i < array.length; i++) {
                list.add(anArray[i]);
            }
        }
        return list;
    }
}