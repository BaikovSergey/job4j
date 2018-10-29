package ru.job4j.array;

/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 29.10.18
 */
public class MatrixCheck {

    /**
     * Проверяет моногамность диагоналей матрицы.
     * @param data массив.
     * @return true/false.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;

        // если матрица четная.
        if (data.length % 2 == 0) {
            for (int i = 0, j = 0; i < data.length && j < data.length; i++, j++) {
                boolean temp = data[0][0];
                if (data[i][j] != temp) {
                    result = false;
                    break;
                }
            }
            for (int i = 0, j = data.length - 1; i < data.length && j >= 0; i++, j--) {
                boolean temp = data[0][data.length - 1];
                if (data[i][j] != temp) {
                    result = false;
                    break;
                }
            }

            // если матрица нечетная.
            } else {
            if (data[0][0] == data[(data.length - 1) / 2][(data.length - 1) / 2]) {
                for (int i = 0, j = 0; i < data.length && j < data.length; i++, j++) {
                    boolean temp = data[0][0];
                    if (data[i][j] != temp) {
                        result = false;
                        break;
                    }
                }
                for (int i = 0, j = data.length - 1; i < data.length && j >= 0; i++, j--) {
                    boolean temp = data[0][data.length - 1];
                    if (data[i][j] != temp) {
                        result = false;
                        break;
                    }
                }
            } else {
                result = false;
            }
        }
        return result;
    }
}