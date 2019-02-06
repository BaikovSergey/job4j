package ru.job4j.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergey Baikov
 * @version $ 1 $
 * @since 06.02.19
 */
public class Matrix {

    /**
     * Метод преобразования двумерного массива (матрицы) в список.
     * @param input Двумерный массив (матрица).
     * @return Список.
     */
    public List<Integer> matrixToList(Integer[][] input) {
        return Arrays.stream(input)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
