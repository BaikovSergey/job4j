package ru.job4j.array;

/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 28.10.18
 */
public class Matrix {

    /**
     * Формирует таблицу умножения заданной размерности.
     * @param size рамерность таблицы.
     * @return массив.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}