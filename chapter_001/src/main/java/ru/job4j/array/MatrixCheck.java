package ru.job4j.array;

/**
 * @author Sergey Baikov
 * @version $Id$
 * @since 29.10.18
 */
public class MatrixCheck {

    /**
     * Проверяет моногамность диагоналей матрицы.
     *
     * @param data массив.
     * @return true/false.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0][0] != data[i][i]) {
                result = false;
                break;
            }
        }
        for (int i = 0, j = data.length - 1; i < data.length && j >= 0; i++, j--) {
            if (data[0][data.length - 1] != data[i][j]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
