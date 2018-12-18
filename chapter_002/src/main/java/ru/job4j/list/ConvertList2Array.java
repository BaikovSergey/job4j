package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 11.12.18
 */
public class ConvertList2Array {

    /**
     * Метод конвертирует список в двумерный массив
     * @param list список
     * @param rows количество строк массива
     * @return двумерный массив
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array = new int[rows][rows];
        int length = list.size();
        int listIndex = 0;
        for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = list.get(listIndex);
                    listIndex++;
                    length--;
                    if (length == 0) {
                        break;
                    }
                }
            }
        return array;
    }

    /**
     * Метод объединяет массивы целых чисел в один общий массив типа Integer
     * @param list литс из массивов
     * @return общий массив
     */
    public List<Integer> convert (List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] aList : list) {
            for (int anAList : aList) {
                result.add(anAList);
            }
        }
       return result;
    }
}